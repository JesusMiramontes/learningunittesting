package com.miramontes.learningunittesting.controller;

import com.miramontes.learningunittesting.business.ItemService;
import com.miramontes.learningunittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired private ItemService itemService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        Item item = Item.builder().id(1).name("Foo").price(10).quantity(100).build();
        System.out.println(item.toString());
        return item;
    }

    @GetMapping("/item-from-service-layer")
    public Item itemFromService() {
        Item item = itemService.retrieveHardcodedItem();
        System.out.println(item.toString());
        return item;
    }
}
