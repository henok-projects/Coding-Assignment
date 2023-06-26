package com.sample.demo;

import com.sample.demo.controllers.ChildController;
import com.sample.demo.controllers.ParentController;
import com.sample.demo.domains.Child;
import com.sample.demo.domains.Parent;
import com.sample.demo.dto.ChildDTO;
import com.sample.demo.dto.ParentDTO;
import com.sample.demo.services.ChildService;
import com.sample.demo.services.ParentService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes=ControllerMokitoTests.class)
public class ControllerMokitoTests {

    @Mock
    ParentService parentService;

    @Mock
    ChildService childService;

    @InjectMocks
    ParentController parentController;

    @InjectMocks
    ChildController childController;
    List<Parent> parents;

    List<Child> children;

    Child child;

    Parent parent;

    @Test
    @Order(1)
    public void test_getAllParents() {
        parents = new ArrayList<Parent>();
        parents.add(new Parent(1, "ABC", "XYZ", 200));
        parents.add(new Parent(2, "ABCD", "XYZE", 300));
        parents.add(new Parent(3, "ABCD", "XYZF", 400));

        when(parentService.list()).thenReturn((List<ParentDTO>) parent); //Moking

        ModelAndView res = parentController.list();
        assertEquals(HttpStatus.FOUND,res.getStatus());
        assertEquals(false,res.isEmpty());

    }

    @Test
    @Order(1)
    public void test_getAllChildren() {
        children = new ArrayList<Child>();
        children.add(new Child(1, 2, 200));
        children.add(new Child(2, 4, 300));
        children.add(new Child(3, 5, 400));

        when(childService.list()).thenReturn((Iterable<Child>) child); //Moking

        ModelAndView res = (ModelAndView) childController.list();
        assertEquals(HttpStatus.FOUND,res.getStatus());
        assertEquals(false,res.isEmpty());

    }
}
