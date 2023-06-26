package com.sample.demo.repositories;

import com.sample.demo.domains.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ParentRepository extends JpaRepository<Parent, Integer> {

    @Query(value = "SELECT sum(u.paidAmount) FROM Child u where u.parentId=?1")
    int getPaidAmount(int parentId);

    @Query(value = "SELECT p FROM Parent p where p.id=?1")

    Parent getParentById(int parentId);

}
