package com.sample.demo.services;

import com.sample.demo.domains.Child;
import com.sample.demo.repositories.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {
    private ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public Iterable<Child> list() {
        return childRepository.findAll();
    }

    public Child save(Child child){
        return childRepository.save(child);
    }

    public Iterable<Child> saveAll(List<Child> childList) {
        return childRepository.saveAll(childList);
    }
}
