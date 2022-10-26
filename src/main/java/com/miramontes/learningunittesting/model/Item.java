package com.miramontes.learningunittesting.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Item {
    private int id;
    private String name;
    private int price;
    private int quantity;
}
