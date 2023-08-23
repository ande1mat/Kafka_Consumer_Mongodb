package com.springkafka.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

@Document(collection = "Inventory")
public class Inventory {

    private long item_id;
    private String store;
    private Integer inventory;
    private LocalDateTime datetime;

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
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

    public LocalDateTime getDatetime() {return datetime;}

    public void setDatetime(LocalDateTime datetime) {this.datetime = datetime;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory1 = (Inventory) o;
        return item_id == inventory1.item_id && Objects.equals(store, inventory1.store) && Objects.equals(inventory, inventory1.inventory) && Objects.equals(datetime, inventory1.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, store, inventory, datetime);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item_id=" + item_id +
                ", store='" + store + '\'' +
                ", inventory=" + inventory +
                ", datetime=" + datetime +
                '}';
    }
}
