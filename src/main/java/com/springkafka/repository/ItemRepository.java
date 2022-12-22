package com.springkafka.repository;

import com.springkafka.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.*;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long > {

    @Query("{id :?0}")                          //SQL Equivalent : SELECT * FROM ITEM WHERE ID=?
    Optional<Item> findBookItemId(Long id);


}

