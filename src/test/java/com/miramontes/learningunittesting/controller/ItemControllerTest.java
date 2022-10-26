package com.miramontes.learningunittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    void dummyItem() throws Exception {
        RequestBuilder request =
                MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult result =
                mockMvc.perform(request)
                        .andExpect(
                                content()
                                        .json(
                                                "{ \"id\": 1, \"name\": \"Foo\", \"price\": 10,"
                                                        + " \"quantity\": 100 }"))
                        .andReturn();
    }
}
