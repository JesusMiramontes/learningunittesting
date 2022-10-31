package com.miramontes.learningunittesting.data;

import com.miramontes.learningunittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {}
