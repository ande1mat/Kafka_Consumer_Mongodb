package com.springkafka.service;

import com.springkafka.domain.ItemMessage;
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


    public ConsumerService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemMessage saveItem (ItemMessage itemMessage) {

        //Should be able to move this above...
        Item itemModel = new Item();

        //Call the Mapper Item Model Mapper
        itemModel = ItemMapper.itemMessagetoItemModel(itemMessage);

        //Save to MongodDB
        //itemRepository.save(itemModel);
        customRepository.update(itemModel);

        return itemMessage;
    }

}
