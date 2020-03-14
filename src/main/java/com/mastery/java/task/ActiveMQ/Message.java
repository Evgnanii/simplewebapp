package com.mastery.java.task.ActiveMQ;

public class Message {
    Long id;
    String title;

    public Message(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


}
