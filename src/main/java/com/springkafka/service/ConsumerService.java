package com.springkafka.service;

import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.mapper.ItemMapper;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;
import com.springkafka.repository.CustomRepository;
import com.springkafka.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ConsumerService {
    @Autowired
    private ItemRepository itemRepository;
    private CustomRepository customRepository;
    private int i;

    public ConsumerService(ItemRepository itemRepository, CustomRepository customRepository) {
        this.itemRepository = itemRepository;
        this.customRepository = customRepository;
    }

    public void saveItem (ItemMessage itemMessage) {

        Item itemModel = new Item();

        //Map the Item Message Domain object to the Item Model Object
        itemModel = ItemMapper.itemMessagetoItemModel(itemMessage);

        //Save the Item Model object to MongodDB
        customRepository.updateItem(itemModel);

    }


    public void saveInventory (List<LocationInventory> inventoryList, Long itemId) {

        //Initialize the model Arraylist to have the same size as Inventory list
        ArrayList<Inventory> modelObjects = new ArrayList<>();

        //Map Location Inventory properties from Domain to Model Inventory
        /*for (i = 0; i < inventoryList.size(); i++) {

            //---DATA EXISTS HERE FINE!  Print out the domain objects
            //System.out.println(i + " domain object   " + inventoryList.get(i).getStore());
            //System.out.println(i + " domain object   " + inventoryList.get(i).getInventory());
            //System.out.println(i + " domain object   " + inventoryList.get(i).getDatetime());

            //THIS WORKS!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //modelObjects2.add(new Inventory("abc", 123, LocalDateTime.parse("2019-03-27T10:15:30")));
            //THIS WORKS!!!!!!!!!!!!!!!!!!!!!!!!!!!

            //THIS WORKS!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //TODO GETTING INDEX OUT OF BOUNDS SOMEWHERE SO FIX THAT, MIGHT NEED TO SET ARRAY SIZE TO inventoryList.size() Or something
            //Map the Domain Objects to the Model Objects
            modelObjects.add(new Inventory(inventoryList.get(i).getStore(), inventoryList.get(i).getInventory(), (inventoryList.get(i).getDatetime())));

            System.out.println(i + " model object   " + modelObjects.get(i).getStore());
            System.out.println(i + " model object   " + modelObjects.get(i).getInventory());
            System.out.println(i + " model object   " + modelObjects.get(i).getRecorddatetime());*/

        //Map the Item Message Domain object to the Item Model Object
        modelObjects = ItemMapper.itemtoInventoryModel(inventoryList, itemId);

        //Save the Inventory Model object to MongodDB
        customRepository.updateInventory(modelObjects);

        }

}
