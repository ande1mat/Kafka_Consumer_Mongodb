package com.springkafka.service;

public interface Roundable {

    public default Integer roundinventory(Integer inventory) {

        System.out.println("value of inventory before rounding = " + inventory);

        //Lets round the inventory for Movies to the nearest tenth position
        inventory = Math.round(inventory/10) * 10;

        System.out.println("value of inventory after rounding = " + inventory);

        return inventory;
    }



}
