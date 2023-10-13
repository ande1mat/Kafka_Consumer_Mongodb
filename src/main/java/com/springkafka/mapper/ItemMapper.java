package com.springkafka.mapper;


import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;
import com.springkafka.service.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ItemMapper {

    //Map the consumed Kafka message to Item Domain Objects
    public static ItemMessage itemtoItemMessage(ItemMessage item) throws IOException {

        ItemMessage itemMessage = new ItemMessage();

        //Map Item properties to Domain ItemMessage
        itemMessage.setItem_id(item.getItem_id());
        itemMessage.setBarcode(item.getBarcode());
        itemMessage.setType(item.getType());
        itemMessage.setDescription(item.getDescription());
        itemMessage.setStyle(item.getStyle());
        itemMessage.setVendor(item.getVendor());
        itemMessage.setCountry(item.getCountry());

        return itemMessage;
    }

    //Map the consumed Kafka message to Inventory MODEL Objects
    public static ArrayList<Inventory> itemtoInventoryModel(List<LocationInventory> inventoryList, Long itemId, String itemType) {

        //Initialize the model Arraylist to have the same size as Inventory list
        ArrayList<Inventory> modelObjects = new ArrayList<>();

        //Define the Movie Object and use the roundable Interface object for the Inventory for Movie types of items
        Movie movie = new Movie();

        int i;

        //Map Location Inventory properties from Domain to Model Inventory

        for (i = 0; i < inventoryList.size(); i++) {
            //Map the Domain Objects to the Model Objects

            if (itemType.equals("movie"))
            modelObjects.add(new Inventory(itemId,
                    inventoryList.get(i).getStore(),
                    movie.roundinventory(inventoryList.get(i).getInventory()),  //Round the Inventory for Item types of Movie
                    (inventoryList.get(i).getDatetime())));
            else  {
                modelObjects.add(new Inventory(itemId,
                        inventoryList.get(i).getStore(),
                        inventoryList.get(i).getInventory(),
                        (inventoryList.get(i).getDatetime())));
            }


            System.out.println(i + " model object item   " + modelObjects.get(i).getItem_id());
            System.out.println(i + " model object store   " + modelObjects.get(i).getStore());
            System.out.println(i + " model object inventory   " + modelObjects.get(i).getInventory());
            System.out.println(i + " model object datetime   " + modelObjects.get(i).getRecorddatetime());

        }

        return modelObjects;

    }

    //Map the consumed Kafka message to Inventory DOMAIN Objects
    public static List<LocationInventory>  itemtoInventoryMessage(ItemMessage item) throws IOException {
        ItemMessage itemMessage = new ItemMessage();

        //Map Location Inventory properties to Domain objects
        itemMessage.setLocation(item.getLocation());
        List<LocationInventory> locObjects = item.getLocation();

        // For loop for iterating over the Domain List
        for (int i = 0; i < locObjects.size(); i++) {
            
            //System.out.println(i + " Domain location item Id   " + locObjects.get(i).getItem_id());
            System.out.println(i + " Domain location store     " + locObjects.get(i).getStore());
            System.out.println(i + " Domain location inventory " + locObjects.get(i).getInventory());
            System.out.println(i + " Domain datetime           " + locObjects.get(i).getDatetime());
        }

        return locObjects;  //Return the List object of Inventory
    }


    //Get the Item Id to map to the Model Object later
    public static Long getItemIdMessage(ItemMessage item) throws IOException {
        ItemMessage itemMessage = new ItemMessage();

        //Map Location Inventory properties to Domain objects
        Long itemMessageID = (item.getItem_id());

        return itemMessageID;
    }

    //Get the Item Type to map to the Model Object later
    public static String getItemTypeMessage(ItemMessage item) throws IOException {
        ItemMessage itemMessage = new ItemMessage();

        //Map Location Inventory properties to Domain objects
        String itemMessagetype = (item.getType());

        return itemMessagetype;
    }

    //Map the Domain objects to the Model objects to insert into MongoDB
    public static Item itemMessagetoItemModel(ItemMessage itemMessage) {

        Item itemModel = new Item();

        //Map Item properties from Domain to Model object
        itemModel.setItem_id(itemMessage.getItem_id());
        itemModel.setBarcode(itemMessage.getBarcode());
        itemModel.setType(itemMessage.getType());
        itemModel.setDescription(itemMessage.getDescription());
        itemModel.setStyle(itemMessage.getStyle());
        itemModel.setVendor(itemMessage.getVendor());
        itemModel.setCountry(itemMessage.getCountry());

        return itemModel;
    }

}
