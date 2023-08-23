package com.springkafka.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ItemMapper {

    //Map the consumed Kafka message to Item Domain Objects
    public static ItemMessage itemtoItemMessage(ItemMessage item) throws IOException {

        ItemMessage itemMessage = new ItemMessage();
        LocationInventory locationInventory = new LocationInventory();

        //Map Item properties
        itemMessage.setItem_id(item.getItem_id());
        itemMessage.setBarcode(item.getBarcode());
        itemMessage.setType(item.getType());
        itemMessage.setDescription(item.getDescription());
        itemMessage.setStyle(item.getStyle());
        itemMessage.setVendor(item.getVendor());
        itemMessage.setCountry(item.getCountry());

        return itemMessage;
    }


    //Map the consumed Kafka message to InventoryDomain Objects
    public static List<LocationInventory>  itemtoInventoryMessage(ItemMessage item) throws IOException {

        ItemMessage itemMessage = new ItemMessage();
        //LocationInventory locationInventory = new LocationInventory();

        //Map Location Inventory properties to Domain objects
        itemMessage.setLocation(item.getLocation());  //THIS WORKS AND ITEM MESSAGE LOCATION LIST IS POPULATED AND MAPPED
            //System.out.println(itemMessage.getLocation()); //LOCATION INFO JSON ARRAY IS POPULATED HERE!!
        List<LocationInventory> locObjects = itemMessage.getLocation();
        //locObjects.stream().forEach(elem -> System.out.println(elem));

        // For loop for iterating over the List
        for (int i = 0; i < locObjects.size(); i++) {

            // Print all elements and feild values of List
            System.out.println(i + "    " + locObjects.get(i).getStore());
            System.out.println(i + "    " + locObjects.get(i).getInventory());
            System.out.println(i + "    " + locObjects.get(i).getDatetime());
        }

        return locObjects;  //Return the List object of Inventory
    }



    //Map the Domain objects to the Model objects to insert into MongoDB
    public static Item itemMessagetoItemModel(ItemMessage itemMessage) {
        //public static Item itemMessagetoItemModel(ItemMessage itemMessage) {

        Item itemModel = new Item();
        //ItemMessage itemMessage = new ItemMessage();

        //Map Item properties from Domain to Model object
        itemModel.setItem_id(itemMessage.getItem_id());
        itemModel.setBarcode(itemMessage.getBarcode());
        itemModel.setType(itemMessage.getType());
        itemModel.setDescription(itemMessage.getDescription());
        itemModel.setStyle(itemMessage.getStyle());
        itemModel.setVendor(itemMessage.getVendor());
        itemModel.setCountry(itemMessage.getCountry());

        //System.out.println(itemModel.toString());
        return itemModel;
    }


    public static Inventory itemMessagetoInventoryModel(List<LocationInventory> inventoryList) {


        //here we need to turn the Item Model into a List and populate it so we can save it to the database
        //the item id will be the same for each List element passed in

        List<LocationInventory> locModelObjects = inventoryList;

        Inventory inventoryModel = new Inventory();
        ItemMessage itemMessage = new ItemMessage();
        LocationInventory locationInventory = new LocationInventory();

        //Map Inventory properties from Domain to Model object
        inventoryModel.setItem_id(itemMessage.getItem_id());
        inventoryModel.setInventory(locationInventory.getInventory());
        inventoryModel.setStore(locationInventory.getStore());
        inventoryModel.setDatetime(locationInventory.getDatetime());

        //System.out.println(itemModel.toString());
        return inventoryModel;
    }

}
