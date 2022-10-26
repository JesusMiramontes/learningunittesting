package com.miramontes.learningunittesting.controller;

import com.miramontes.learningunittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        Item item = Item.builder().id(1).name("Foo").price(10).quantity(100).build();
        System.out.println(item.toString());
        return item;
    }
}
