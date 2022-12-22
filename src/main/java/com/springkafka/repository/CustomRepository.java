package com.springkafka.repository;

import com.springkafka.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List findAll() {
        return mongoTemplate.findAll(Item.class);
    }

    public Item save(Item item) {
        mongoTemplate.save(item);
        return item;
    }

    /*{"item_id":1, "barcode":"A123456789", "type":"testing", "description":"The Arrival of a Test","country":"TEST"}*/
    public Item update(Item item){
        Query query = new Query();
        query.addCriteria(Criteria.where("item_id").is(item.getItem_id()));
        Update update = new Update();
        update.set("barcode", item.getBarcode());
        update.set("type", item.getType());
        update.set("description", item.getDescription());
        update.set("country", item.getCountry());
        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Item.class);  //do the UPSERT True here
    }
    

    /*public List findByItem_id(Long Item_id){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(Item_id));
        return mongoTemplate.find(query, Item.class);
    }

    public void deleteById(String deptId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(deptId));
        mongoTemplate.remove(query, Department.class);
    }*/

}
