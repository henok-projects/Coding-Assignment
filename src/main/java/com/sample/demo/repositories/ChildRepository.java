package com.sample.demo.repositories;

import com.sample.demo.domains.Child;
import com.sample.demo.dto.ChildDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Integer> {

    @Query("SELECT new com.sample.demo.dto.CommonDTO(c.id, c.parentId, c.paidAmount, p.sender, p.receiver, p.totalAmount) from Parent p, Child c WHERE p.id = c.parentId")
    List<ChildDTO> findChildById(int id);

}
