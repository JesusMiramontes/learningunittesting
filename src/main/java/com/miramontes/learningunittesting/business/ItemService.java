package com.miramontes.learningunittesting.business;

import com.miramontes.learningunittesting.data.ItemRepository;
import com.miramontes.learningunittesting.model.Item;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item retrieveHardcodedItem() {
        return Item.builder().id(1).name("Bar").price(200).quantity(200).build();
    }

    public List<Item> findAll() {
        List<Item> itemList = itemRepository.findAll();
        itemList.forEach(
                item -> {
                    item.setValue(item.getPrice() * item.getQuantity());
                });
        return itemList;
    }
}
