package com.example.shop_store.repos;

import com.example.shop_store.domain.Pakets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaketsRepo extends CrudRepository<Pakets, Long> {
    List<Pakets> findAllByName(String name);

    List<Pakets> findAllByArtikul(String artikul);

    List<Pakets> findAllByPrice(double price);
}
