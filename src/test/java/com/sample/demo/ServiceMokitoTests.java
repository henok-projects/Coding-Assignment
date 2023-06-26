package com.sample.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.sample.demo.domains.Parent;
import com.sample.demo.repositories.ParentRepository;
import com.sample.demo.services.ParentService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {ServiceMokitoTests.class})
public class ServiceMokitoTests {
    @Mock
    ParentRepository parentRepository;

    @InjectMocks
    ParentService parentService;

    public List<Parent> parents;

    @Test
    @Order(1)
    public void test_getAllCountries() {

        List<Parent> parents= new ArrayList<Parent>();

        parents.add(new Parent(1, "ABC", "XYZ", 200));
        parents.add(new Parent(2, "ABCD", "XYZE", 300));
        parents.add(new Parent(3, "ABCD", "XYZF", 400));

        when(parentRepository.findAll()).thenReturn(parents); // Moking statement
        assertEquals(3,parentService.list());
    }


    @Test
    @Order(2)
    public void test_getCountryByName() {

        List<Parent> parents= new ArrayList<Parent>();

        parents.add(new Parent(20, "ABC", "XYZ", 200));
        parents.add(new Parent(21, "ABCD", "XYZE", 300));
        parents.add(new Parent(22, "ABCD", "XYZF", 400));
        int id = 4;

        when(parentRepository.findAll()).thenReturn(parents); // Moking statement
        assertEquals(null, parentService.findAll());

    }

}
