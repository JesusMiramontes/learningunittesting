package com.miramontes.learningunittesting.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception {
        // Call endpoint
        RequestBuilder request =
                MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);

        // Store response
        MvcResult result = mockMvc.perform(request).andReturn();

        // Verify response
        assertEquals("Hello world.", result.getResponse().getContentAsString());
    }
}
