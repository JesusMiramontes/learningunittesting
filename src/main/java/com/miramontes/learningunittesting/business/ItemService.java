package com.miramontes.learningunittesting.business;

import com.miramontes.learningunittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    public Item retrieveHardcodedItem() {
        return Item.builder().id(1).name("Bar").price(200).quantity(200).build();
    }
}
