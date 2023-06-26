package com.sample.demo.services;

import com.sample.demo.domains.Child;
import com.sample.demo.domains.Parent;
import com.sample.demo.dto.ChildDTO;
import com.sample.demo.repositories.ChildRepository;
import com.sample.demo.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildService {
    private ChildRepository childRepository;

    private ParentRepository parentRepository;


    private ParentService parentService;

    public ChildService(ChildRepository childRepository, ParentRepository parentRepository,ParentService parentService) {
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;
        this.parentService = parentService;
    }

    public List<ChildDTO> list(int parentId) {

        List<Child>  children = childRepository.getChildren(parentId);

        for(Child child:children){
            System.out.println("child  "+ child);
        }

        List<ChildDTO> newChildren = new ArrayList<>();

        Parent parent = parentRepository.getParentById(parentId);

        for(Child child : children){
            ChildDTO childDto = new ChildDTO();
            childDto.setId(child.getId());
            childDto.setTotalAmount(child.getPaidAmount());
            childDto.setReceiver(parent.getReceiver());
            childDto.setSender(parent.getSender());
            childDto.setPaidAmount(parentService.getPaidAmount(parentId));
            newChildren.add(childDto);
        }
        return newChildren;


    }

    public Child save(Child child){
        return childRepository.save(child);
    }

    public Iterable<Child> saveAll(List<Child> childList) {
        return childRepository.saveAll(childList);
    }
}
