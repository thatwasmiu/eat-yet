package com.example.eatyet.core;

import com.example.eatyet.core.base.BaseEndpoint;
import com.example.eatyet.core.utils.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public class RestApiEndpoint<T extends AutoIdEntity, ID extends Serializable> extends BaseEndpoint {

    private final CrudService<T, ID> service;

    public RestApiEndpoint(String url, CrudService<T, ID> service) {
        super(url);
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll(Pageable pageable) {
        super.beforeAdvice(APIMethod.GET, "");
        Page<T> page = service.list(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, url);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public T get(@PathVariable(value = "id") ID id) {
        super.beforeAdvice(APIMethod.GET, id.toString());
        return service.getOne(id);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T object) {
        super.beforeAdvice(APIMethod.POST, "");
        T entity = service.create(object);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public T update(@RequestBody T object, @PathVariable(value = "id") ID id) {
        super.beforeAdvice(APIMethod.PUT, "");
        if (!id.equals(object.getId())) throw new RuntimeException("");
        return service.update(object);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id) {
        super.beforeAdvice(APIMethod.DELETE, "/" + id.toString());
        service.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<T>> get(@RequestParam("query") String query, @PageableDefault(size = 20) Pageable pageable) {
        super.beforeAdvice(APIMethod.GET, "/search?query=="+query);
        try{
            Page<T> page = service.search(query, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, url);
            return new ResponseEntity<>(page.getContent(),headers, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
