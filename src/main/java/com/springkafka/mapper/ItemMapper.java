package com.springkafka.mapper;

import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.model.Inventory;
import com.springkafka.model.Item;

public class ItemMapper {

    //Map the consumed Kafka message to Domain Objects
    public static ItemMessage  itemtoItemMessage(ItemMessage item) {

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


        itemMessage.setLocation(item.getLocation());

        System.out.println(itemMessage.toString());

        //If this is populated already from 2 lines above, then i'm golden and i can
        //just do the mapping below, then on Save make a second call to update a new Inventory Collection in MongDB!!
        System.out.println(locationInventory.toString());


        return itemMessage;
    }


    //Map the Domain objects to the Model objects to insert into MongoDB
    public static Item itemMessagetoItemModel() {
        //public static Item itemMessagetoItemModel(ItemMessage itemMessage) {

        Item itemModel = new Item();
        ItemMessage itemMessage = new ItemMessage();

        //Map Item properties
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

        //Map Inventory properties

        //itemModel.setLocation(itemMessage.getLocation());
        //Here i think i would need to map the LocationInventory domain to the new Inventory Model
        //Need to create a new Inventory Model Object too.
        //Map Inventory properties
        //inventoryModel.setItem_id(itemMessage.getItem_id());
        //inventoryModel.setInventory();

        //System.out.println(itemModel.toString());
        return inventoryModel;
    }

}
