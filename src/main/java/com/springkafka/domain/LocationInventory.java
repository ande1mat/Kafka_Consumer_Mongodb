package com.springkafka.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Objects;


public class LocationInventory {

    public LocationInventory(Long item_id){
        this.item_id = item_id;
    }

    @JsonProperty("item_id")
    private Long item_id;

    @JsonProperty("store")
    private String store;

    @JsonProperty("inventory")
    private Integer inventory;

    @JsonProperty("datetime")
    private LocalDateTime datetime;

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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationInventory that = (LocationInventory) o;
        return Objects.equals(item_id, that.item_id) && Objects.equals(store, that.store) && Objects.equals(inventory, that.inventory) && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, store, inventory, datetime);
    }

    @Override
    public String toString() {
        return "LocationInventory{" +
                "item_id=" + item_id +
                ", store='" + store + '\'' +
                ", inventory=" + inventory +
                ", datetime=" + datetime +
                '}';
    }
}
