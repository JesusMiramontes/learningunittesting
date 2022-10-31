package com.miramontes.learningunittesting.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id private int id;

    private String name;
    private int price;
    private int quantity;

    @Transient private int value;
}
