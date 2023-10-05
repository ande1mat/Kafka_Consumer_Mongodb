package com.springkafka.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DeadLetter")
public class DeadLetter {

    private String dead_message;
    private String reason;

    public String getDead_message() {
        return dead_message;
    }

    public void setDead_message(String dead_message) {
        this.dead_message = dead_message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
