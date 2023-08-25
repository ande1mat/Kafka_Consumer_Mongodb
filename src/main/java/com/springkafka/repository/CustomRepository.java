package com.springkafka.repository;

import com.springkafka.domain.ItemMessage;
import com.springkafka.model.Inventory;
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
    //This method will perform a Upsert (findAndModify), so it will insert if item_id is new, and update if it exists
    public Item updateItem(Item item){
        Query query = new Query();
        query.addCriteria(Criteria.where("item_id").is(item.getItem_id()));
        Update update = new Update();
        update.set("barcode", item.getBarcode());
        update.set("type", item.getType());
        update.set("description", item.getDescription());
        update.set("country", item.getCountry());
        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Item.class);  //do the UPSERT True here
    }

    /*Sample JSON Message for Terminal window producer NEW
    {"item_id":1,"barcode":"A123456789","type":"movie","description":"The Arrival of a Train","country":"USA","location":
    [{"store":"100","inventory":"25","datetime":"2023-04-14T18:56:30Z"},{"store":"200","inventory":"99","datetime":"2023-04-14T18:56:30Z"},
    {"store":"300","inventory":"250","datetime":"2023-04-14T18:56:30Z"}]}*/

    //This method will perform a Upsert (findAndModify), so it will insert if item_id is new, and update if it exists
    public List<Inventory> updateInventory(List<Inventory> inventory){

        //Query query = new Query();
        //query.addCriteria(Criteria.where("item_id").is(inventory.getItem_id()));
        //Update update = new Update();
        //update.set("item_id", inventory.getItem_id());
        //update.set("store", inventory.getStore());
        //update.set("inventory", inventory.getInventory());
        //update.set("datetime", inventory.getDatetime());
        //return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Inventory.class);  //do the UPSERT True here

        return inventory;  //remove this later and return Location inventory above....

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
