package com.sample.demo.services;

import com.sample.demo.domains.Parent;
import com.sample.demo.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
    public Iterable<Parent> list() {
        return parentRepository.findAll();
    }

    public Parent save(Parent parent){
        return parentRepository.save(parent);
    }
    public Iterable<Parent> saveAll(List<Parent> parents) {
       return parentRepository.saveAll(parents);
    }
}
