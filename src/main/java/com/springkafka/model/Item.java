package com.springkafka.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

/*{"item_id":1, "barcode":"A123456789", "type":"testing", "description":"The Arrival of a Test","country":"TEST"}*/

@Document(collection = "Item")
public class Item {

    private long item_id;
    private String barcode;
    private String type;
    private String description;
    private String country;

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return item_id == item.item_id && Objects.equals(barcode, item.barcode) && Objects.equals(type, item.type) && Objects.equals(description, item.description) && Objects.equals(country, item.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, barcode, type, description, country);
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", barcode='" + barcode + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
