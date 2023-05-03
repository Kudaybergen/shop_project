package com.example.shop_store.repos;

import com.example.shop_store.domain.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepo extends CrudRepository<Goods, Long> {

}
