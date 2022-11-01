package com.miramontes.learningunittesting.data;

import com.miramontes.learningunittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void findAll_size(){
        List<Item> itemRepositoryAll = itemRepository.findAll();
        assertEquals(3, itemRepositoryAll.size());
    }

}