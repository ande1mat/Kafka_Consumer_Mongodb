package com.springkafka.service;

import com.springkafka.domain.ItemMessage;
import com.springkafka.domain.LocationInventory;
import com.springkafka.mapper.ItemMapper;
import com.springkafka.model.Item;
import com.springkafka.repository.CustomRepository;
import com.springkafka.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
    @Autowired
    private ItemRepository itemRepository;
    private CustomRepository customRepository;

    public ConsumerService(ItemRepository itemRepository, CustomRepository customRepository) {
        this.itemRepository = itemRepository;
        this.customRepository = customRepository;
    }

    public ItemMessage saveItem (ItemMessage itemMessage) {

        //Should be able to move this above...
        Item itemModel = new Item();

        //Map the Item Message Domain object to the Item Model Object
        itemModel = ItemMapper.itemMessagetoItemModel(itemMessage);

        //Save the Item Model object to MongodDB
        customRepository.update(itemModel);

        return itemMessage;
    }

}
