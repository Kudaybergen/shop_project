package com.example.shop_store.repos;

import com.example.shop_store.domain.Goods;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepo extends CrudRepository<Goods, Long> {
    List<Goods> findAllByCategory(Integer category);
}
