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
import java.util.List;

public class ItemMapper {

    //Map the consumed Kafka message to Domain Objects
    public static ItemMessage  itemtoItemMessage(ItemMessage item) throws IOException {

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

        //Map Location Inventory properties to Domain object
        itemMessage.setLocation(item.getLocation());  //THIS WORKS AND ITEM MESSAGE LOCATION LIST IS POPULATED AND MAPPED
        System.out.println(itemMessage.getLocation()); //LOCATION INFO JSON ARRAY IS POPULATED HERE!!
        //locationInventory.setStore(itemMessage.getLocation());


        /*lets create a List of the location info to manage later

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String jsonInput = "[{\"store\":\"100\",\"inventory\":\"25\",\"datetime\":\"2023-04-14T18:56:30Z\"},{\"store\":\"200\",\"inventory\":\"99\",\"datetime\":\"2020-05-21T07:37:11.000\"},{\"store\":\"300\",\"inventory\":\"250\",\"datetime\":\"2020-05-21T07:37:11.000\"}]";

        List<LocationInventory> locObjects = mapper.readValue(jsonInput, new TypeReference<List<LocationInventory>>(){});

        for (LocationInventory locinv : locObjects) {
            System.out.println(locinv.toString());
        }
         */

        return itemMessage;
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


    public static Inventory itemMessagetoInventoryModel() {


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
