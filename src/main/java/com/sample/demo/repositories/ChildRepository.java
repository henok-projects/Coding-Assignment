package com.sample.demo.repositories;

import com.sample.demo.domains.Child;
import com.sample.demo.dto.ChildDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Integer> {
    @Query(value = "SELECT u FROM Child u where u.parentId=?1")
    List<Child> getChildren(int parentId);

}
