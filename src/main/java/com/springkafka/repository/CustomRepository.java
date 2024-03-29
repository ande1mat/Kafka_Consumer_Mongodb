package com.springkafka.repository;

import com.springkafka.model.DeadLetter;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    //This method will perform an Upsert (findAndModify), so it will insert if item_id is new, and update if it exists
    public void updateItem(Item item){
        Query query = new Query();
        query.addCriteria(Criteria.where("item_id").is(item.getItem_id()));
        Update update = new Update();
        update.set("barcode", item.getBarcode());
        update.set("type", item.getType());
        update.set("description", item.getDescription());
        update.set("country", item.getCountry());
        mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Item.class);  //do the UPSERT True here
    }
    

    //This method will perform an Upsert (findAndModify), so it will insert if item_id is new, and update if it exists
    public void updateInventory(List<Inventory> locationInventories){

        //Loop through the Inventory List and Upsert into MongoDB
        for (int i = 0; i < locationInventories.size(); i++) {
            Query query = new Query();
            query.addCriteria(Criteria.where("item_id").is(locationInventories.get(i).getItem_id()));
            query.addCriteria(Criteria.where("store").is(locationInventories.get(i).getStore()));
            Update update = new Update();
            update.set("item_id", locationInventories.get(i).getItem_id());
            update.set("store", locationInventories.get(i).getStore());
            update.set("inventory", locationInventories.get(i).getInventory());
            update.set("datetime", locationInventories.get(i).getRecorddatetime());
            mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Inventory.class);  //do the UPSERT True here
        }
    }

    //Insert the deadletter message to MongoDB
    public void saveDeadLetter(String deadMessage, String reason){
        DeadLetter deadletter = new DeadLetter();
        deadletter.setDead_message(deadMessage);
        deadletter.setReason(reason);

        mongoTemplate.insert(deadletter);
    }

    //Future could be used for a find operation
    /*public List findByItem_id(Long Item_id){
        Query query = new Query();
        query.addCriteria(Criteria.where("item_id").is(Item_id));
        return mongoTemplate.find(query, Item.class);
    }

    //Future could be used for a delete operation
    public void deleteById(String deptId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("item_id").is(Item_id));
        mongoTemplate.remove(query, Item.class);
    }*/

}
