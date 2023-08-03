package com.example.eatyet.core;

import com.example.eatyet.core.base.BaseEntity;
import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.core.rsql.EndpointRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Transactional
public class CrudService <T extends BaseEntity, ID extends Serializable> {

    private final BaseJpaRepository<T, ID> repo;

    public CrudService(BaseJpaRepository<T, ID> repo) {
        this.repo = repo;
    }

    public Page<T> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public T upSert(T entity) {
        return repo.save(entity);
    }

    public void delete(T entity) {
        repo.delete(entity);
    }

    public void deleteById(ID id) {
        repo.deleteById(id);
    }

    public Page<T> search(String query, Pageable pageable) {
        query = URLDecoder.decode(query, StandardCharsets.UTF_8);
        return query(query, pageable);
    }

    public Page<T> query(String query, Pageable pageable){
        if(!StringUtils.hasLength(query)){
            return repo.findAll(pageable);
        }
        try {
            Node rootNode = new RSQLParser().parse(query);
            Specification<T> spec = rootNode.accept(new EndpointRsqlVisitor<>());
            return repo.findAll(spec, pageable);
        } catch(Exception pe) {
            pe.printStackTrace();
            return Page.empty();
        }
    }

    public T getOne(ID id) {
        Optional<T> entity = repo.findById(id);
        if (!entity.isPresent()) throw new RuntimeException("Entity not found");
        return entity.get();
    }
}
