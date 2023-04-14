package com.springkafka.mapper;

import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.model.Item;

public class ItemMapper {

    //Map the consumed Kafka message to Domain Objects
    public static ItemMessage  itemtoItemMessage(ItemMessage item) {

        ItemMessage itemMessage = new ItemMessage();
        LocationInventory locationInventory = new LocationInventory();

        itemMessage.setItem_id(item.getItem_id());
        itemMessage.setBarcode(item.getBarcode());
        itemMessage.setType(item.getType());
        itemMessage.setDescription(item.getDescription());
        itemMessage.setCountry(item.getCountry());
        itemMessage.setLocation(item.getLocation());

        System.out.println(itemMessage.toString());

        //Is this is populated already from 2 lines above, then i'm golden and i can
        //just do the mapping below, then on Save make a second call to update a new Inventory Collection in MongDB!!
        System.out.println(locationInventory.toString());
        return itemMessage;
    }


    //Map the Domain objects to the Model objects to insert into MongoDB
    public static Item itemMessagetoItemModel(ItemMessage itemMessage) {

        Item itemModel = new Item();

        itemModel.setItem_id(itemMessage.getItem_id());
        itemModel.setBarcode(itemMessage.getBarcode());
        itemModel.setType(itemMessage.getType());
        itemModel.setDescription(itemMessage.getDescription());
        itemModel.setCountry(itemMessage.getCountry());

        //itemModel.setLocation(itemMessage.getLocation());
        //Here i think i would need to map the LocationInventory domain to the new Inventory Model
        //Need to create a new Inventory Model Object too.

        //System.out.println(itemModel.toString());
        return itemModel;
    }



}
