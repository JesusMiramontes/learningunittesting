package com.miramontes.learningunittesting.model;

import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
public class Item {
    @Id private int id;

    private String name;
    private int price;
    private int quantity;

    @Transient private int value;
}
