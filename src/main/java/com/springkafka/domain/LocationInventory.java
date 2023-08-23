package com.springkafka.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;


//"location_inventory":[{"store":"100","inventory":"25","datetime":"2023-04-14T18:56:30Z"},{"store":"200","inventory":"99","datetime":"2023-04-14T18:56:30Z"},{"store":"300","inventory":"250","datetime":"2023-04-14T18:56:30Z"}]}

public class LocationInventory {

    @JsonProperty("store")
    private String store;

    @JsonProperty("inventory")
    private Integer inventory;

    @JsonProperty("datetime")
    private LocalDateTime datetime;

    public String getStore() {return store;}

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
        return Objects.equals(store, that.store) && Objects.equals(inventory, that.inventory) && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, inventory, datetime);
    }

    @Override
    public String toString() {
        return "LocationInventory{" +
                "store='" + store + '\'' +
                ", inventory=" + inventory +
                ", datetime=" + datetime +
                '}';
    }
}
