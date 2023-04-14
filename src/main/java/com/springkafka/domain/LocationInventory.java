package com.springkafka.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

public class LocationInventory {

    @JsonProperty("store")
    private String store;

    @JsonProperty("inventory")
    private String inventory;

    @JsonProperty("datetime")
    private OffsetDateTime datetime;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public OffsetDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(OffsetDateTime datetime) {
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
                ", inventory='" + inventory + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
