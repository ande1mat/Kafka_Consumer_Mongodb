package com.springkafka.mapper;

import com.springkafka.domain.ItemMessage;
import com.springkafka.model.Item;

public class ItemMapper {

    public static ItemMessage  itemtoItemMessage(ItemMessage item) {

        ItemMessage itemMessage = new ItemMessage();

        itemMessage.setItem_id(item.getItem_id());
        itemMessage.setBarcode(item.getBarcode());
        itemMessage.setType(item.getType());
        itemMessage.setDescription(item.getDescription());
        itemMessage.setCountry(item.getCountry());

        System.out.println(itemMessage.toString());
        return itemMessage;
    }


    public static Item itemMessagetoItemModel(ItemMessage itemMessage) {

        Item itemModel = new Item();

        itemModel.setItem_id(itemMessage.getItem_id());
        itemModel.setBarcode(itemMessage.getBarcode());
        itemModel.setType(itemMessage.getType());
        itemModel.setDescription(itemMessage.getDescription());
        itemModel.setCountry(itemMessage.getCountry());

        System.out.println(itemModel.toString());
        return itemModel;
    }



}
