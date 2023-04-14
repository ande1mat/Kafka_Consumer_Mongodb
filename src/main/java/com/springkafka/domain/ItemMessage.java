package com.springkafka.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/*
//Sample JSON Message for Terminal window producer OLD
{"item_id":1, "barcode":"A123456789", "type":"movie", "description":"The Arrival of a Train", "country":"USA"}


//Sample JSON Message for Terminal window producer NEW
{"item_id":1,"barcode":"A123456789","type":"movie","description":"The Arrival of a Train","country":"USA","location":
[{"store":"100","inventory":"25","datetime":"2023-04-14T18:56:30Z"},{"store":"200","inventory":"99","datetime":"2023-04-14T18:56:30Z"},
{"store":"300","inventory":"250","datetime":"2023-04-14T18:56:30Z"}]}


 */

public class ItemMessage {

    @JsonProperty("item_id")  //This is the name that actually what gets returned in the JSON
    private Long item_id;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("type")
    private String type;

    @JsonProperty("description")
    private String description;

    @JsonProperty("country")
    private String country;

    @JsonProperty("location")
    private List<LocationInventory> location;

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<LocationInventory> getLocation() {
        return location;
    }

    public void setLocation(List<LocationInventory> location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemMessage that = (ItemMessage) o;
        return Objects.equals(item_id, that.item_id) && Objects.equals(barcode, that.barcode) && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(country, that.country) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, barcode, type, description, country, location);
    }

    @Override
    public String toString() {
        return "ItemMessage{" +
                "item_id=" + item_id +
                ", barcode='" + barcode + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", location=" + location +
                '}';
    }
}
