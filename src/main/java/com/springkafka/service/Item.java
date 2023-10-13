package com.springkafka.service;

public abstract class Item {

    public Item(String type, Integer inventory) {
        this.type = type;
        this.inventory = inventory;
    }

    private String type;
    private Integer inventory;

    public Item() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
