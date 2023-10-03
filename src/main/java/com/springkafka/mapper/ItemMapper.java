package com.springkafka.mapper;

import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;
import java.io.IOException;
import java.util.*;

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

    //Map the consumed Kafka message to InventoryDomain Objects
    public static ArrayList<Inventory> itemtoInventoryModel(List<LocationInventory> inventoryList) {

        //Initialize the model Arraylist to have the same size as Inventory list
        ArrayList<Inventory> modelObjects = new ArrayList<>();

        //Define the Domain Inventory Array List
        //List<LocationInventory> inventoryList  = new ArrayList<LocationInventory>();

        int i;

        //Map Location Inventory properties from Domain to Model Inventory

        for (i = 0; i < inventoryList.size(); i++) {

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
            modelObjects.add(new Inventory(inventoryList.get(i).getItem_id(),
                    inventoryList.get(i).getStore(),
                    inventoryList.get(i).getInventory(),
                    (inventoryList.get(i).getDatetime())));

            System.out.println(i + " model object item   " + modelObjects.get(i).getItem_id());
            System.out.println(i + " model object store   " + modelObjects.get(i).getStore());
            System.out.println(i + " model object inventory   " + modelObjects.get(i).getInventory());
            System.out.println(i + " model object datetime   " + modelObjects.get(i).getRecorddatetime());

        }

        return modelObjects;

    }

    //Map the consumed Kafka message to InventoryDomain Objects
    public static List<LocationInventory>  itemtoInventoryMessage(ItemMessage item) throws IOException {
        ItemMessage itemMessage = new ItemMessage();

        //Map Location Inventory properties to Domain objects
        itemMessage.setLocation(item.getLocation());
        List<LocationInventory> locObjects = item.getLocation();

        // For loop for iterating over the Domain List
        for (int i = 0; i < locObjects.size(); i++) {

            //LETS ADD IN THE ITEM ID to the LOCATION DOMAIN OBJECT SO WE CAN USE IT LATER
            locObjects.set(i, new LocationInventory(item.getItem_id()));

            System.out.println(i + " Domain location item Id   " + locObjects.get(i).getItem_id());
            System.out.println(i + " Domain location store     " + locObjects.get(i).getStore());
            System.out.println(i + " Domain location inventory " + locObjects.get(i).getInventory());
            System.out.println(i + " Domain datetime           " + locObjects.get(i).getDatetime());
        }

        return locObjects;  //Return the List object of Inventory
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
