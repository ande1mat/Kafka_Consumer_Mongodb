package com.springkafka.repository;

import com.springkafka.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long > {

    @Query("{id :?1}")                          //SQL Equivalent : SELECT * FROM ITEM WHERE Item_ID=1
    Optional<Item> FindByItemId(Long id);


}

