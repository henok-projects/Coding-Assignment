package com.sample.demo.services;

import com.sample.demo.domains.Parent;
import com.sample.demo.dto.ParentDTO;
import com.sample.demo.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    private ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent save(Parent parent){
        return parentRepository.save(parent);
    }
    public Iterable<Parent> saveAll(List<Parent> parents) {
       return parentRepository.saveAll(parents);
    }

    public Iterable<Parent> findAll() {
        Iterable<Parent> parents =  parentRepository.findAll();
        return parents;
    }

    public List<ParentDTO>  list() {

        List<Parent>  parents = (List<Parent>) parentRepository.findAll();

        List<ParentDTO> newParents = new ArrayList<>();

        for(Parent parent : parents){
            ParentDTO parentDto = new ParentDTO();
            int id = parent.getId();

            parentDto.setId(parent.getId());
            parentDto.setReceiver(parent.getReceiver());
            parentDto.setSender(parent.getSender());
            parentDto.setTotalAmount(parent.getTotalAmount());
            try {
                parentDto.setTotalPaidAmount(getPaidAmount(id));
            } catch (Exception e) {
                parentDto.setTotalPaidAmount(0);
            }
            newParents.add(parentDto);
        }
        return newParents;
    }


    public int getPaidAmount(int parentId){
        return parentRepository.getPaidAmount(parentId);
    }

}
