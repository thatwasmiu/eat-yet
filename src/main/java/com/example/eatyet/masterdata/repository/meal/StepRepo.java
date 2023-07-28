package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.masterdata.model.meal.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepo extends JpaRepository<Step, Long> {
}
