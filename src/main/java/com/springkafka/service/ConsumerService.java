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


    public void saveInventory (List<LocationInventory> inventoryList, Long itemId, String itemType) {
        //Initialize the model Arraylist to have the same size as Inventory list
        ArrayList<Inventory> modelObjects = new ArrayList<>();

        //Map the Item Message Domain object to the Item Model Object
        modelObjects = ItemMapper.itemtoInventoryModel(inventoryList, itemId, itemType);

        //Save the Inventory Model object to MongodDB
        customRepository.updateInventory(modelObjects);
        }

    public void saveDeadLetter (String deadMessage, String reason) {
        //Save the Item Model object to MongodDB
        customRepository.saveDeadLetter(deadMessage, reason);

    }

}
