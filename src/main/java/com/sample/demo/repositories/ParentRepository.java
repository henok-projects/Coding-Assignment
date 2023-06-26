package com.sample.demo.repositories;

import com.sample.demo.domains.Parent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<Parent, Integer> {

}
