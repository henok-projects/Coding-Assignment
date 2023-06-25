package com.sample.demo.repositories;

import com.sample.demo.domains.Parent;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent, Integer> {
}
