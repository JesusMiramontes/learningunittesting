package com.miramontes.learningunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.miramontes.learningunittesting.data.ItemRepository;
import com.miramontes.learningunittesting.model.Item;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @InjectMocks private ItemService itemService;

    @Mock private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        when(itemRepository.findAll())
                .thenReturn(
                        Arrays.asList(
                                Item.builder().id(1).name("Foo").price(100).quantity(100).build(),
                                Item.builder().id(2).name("Bar").price(200).quantity(200).build()));
    }

    @Test
    void validateValue() {
        List<Item> itemServiceAll = itemService.findAll();
        assertEquals(10_000, itemServiceAll.get(0).getValue());
        assertEquals(40_000, itemServiceAll.get(1).getValue());
    }
}
