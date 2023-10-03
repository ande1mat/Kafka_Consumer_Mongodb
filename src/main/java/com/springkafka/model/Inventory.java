package com.springkafka.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "Inventory")
public class Inventory {

    private Long item_id;
    public String store;
    public Integer inventory;
    public LocalDateTime recorddatetime;

    public Inventory(Long item_id, String store, Integer inventory, LocalDateTime recorddatetime){
        this.item_id = item_id;
        this.store = store;
        this.inventory = inventory;
        this.recorddatetime = recorddatetime;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public LocalDateTime getRecorddatetime() {
        return recorddatetime;
    }

    public void setRecorddatetime(LocalDateTime recorddatetime) {
        this.recorddatetime = recorddatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory1 = (Inventory) o;
        return Objects.equals(item_id, inventory1.item_id) && Objects.equals(store, inventory1.store) && Objects.equals(inventory, inventory1.inventory) && Objects.equals(recorddatetime, inventory1.recorddatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, store, inventory, recorddatetime);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item_id=" + item_id +
                ", store='" + store + '\'' +
                ", inventory=" + inventory +
                ", recorddatetime=" + recorddatetime +
                '}';
    }




}
