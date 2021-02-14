package com.embl.assessment.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embl.assessment.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}