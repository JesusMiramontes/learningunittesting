package com.miramontes.learningunittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.miramontes.learningunittesting.business.ItemService;
import com.miramontes.learningunittesting.model.Item;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private ItemService itemServiceMock;

    @BeforeEach
    void setUp() {
        when(itemServiceMock.retrieveHardcodedItem())
                .thenReturn(Item.builder().id(1).name("Bar").price(200).quantity(200).build());
        when(itemServiceMock.findAll())
                .thenReturn(
                        Arrays.asList(
                                Item.builder().id(1).name("Foo").price(100).quantity(100).build(),
                                Item.builder().id(2).name("Bar").price(200).quantity(200).build()));
    }

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

    @Test
    void itemFromService() throws Exception {
        RequestBuilder request =
                MockMvcRequestBuilders.get("/item-from-service-layer")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result =
                mockMvc.perform(request)
                        .andExpect(content().json("{id:1, name:Bar, price:200, quantity:200}"))
                        .andReturn();
    }

    @Test
    void retrieveAllItemsService() throws Exception {
        RequestBuilder request =
                MockMvcRequestBuilders.get("/all-items-from-db").accept(MediaType.APPLICATION_JSON);
        MvcResult result =
                mockMvc.perform(request)
                        .andExpect(
                                content()
                                        .json(
                                                "[{id:1, name:Foo, price:100, quantity:100},"
                                                        + " {id:2, name:Bar, price:200,"
                                                        + " quantity:200}]"))
                        .andReturn();
    }
}
