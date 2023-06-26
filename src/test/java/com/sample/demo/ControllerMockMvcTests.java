package com.sample.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.sample.demo.controllers.ChildController;
import com.sample.demo.domains.Child;
import com.sample.demo.dto.ChildDTO;
import com.sample.demo.services.ChildService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@TestMethodOrder(OrderAnnotation.class)
@ComponentScan(basePackages="com.rest.service")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {ControllerMokitoTests.class})
public class ControllerMockMvcTests {
    @Autowired
    MockMvc mockMvc;

    @Mock
    ChildService childService;

    @InjectMocks
    ChildController childController;

    List<Child> children;

    Child child;

    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(childController).build();
    }


    @Test
    @Order(1)
    public void test_getChildById() throws Exception {

        children = new ArrayList<Child>();
        children.add(new Child(20, 3, 200));
        children.add(new Child(21, 3, 300));
        children.add(new Child(22, 3, 400));
        int id = 2;
        when(childService.findChildById(id)).thenReturn((List<ChildDTO>) child); //Moking
        mockMvc.perform(get("/parentId"))
                .andExpect(status().isFound())
                .andDo(print());
    }
}
