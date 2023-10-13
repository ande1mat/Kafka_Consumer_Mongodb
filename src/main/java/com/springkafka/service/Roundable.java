package com.springkafka.service;

public interface Roundable {

    public default Integer roundinventory(Integer inventory) {

        System.out.println("value of inventory before rounding = " + inventory);

        //Lets round the inventory for Movies
        inventory = Math.round(inventory);

        System.out.println("value of inventory after rounding = " + inventory);

        return inventory;
    }



}
