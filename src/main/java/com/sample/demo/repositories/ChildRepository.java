package com.sample.demo.repositories;

import com.sample.demo.domains.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child, Integer> {
}
