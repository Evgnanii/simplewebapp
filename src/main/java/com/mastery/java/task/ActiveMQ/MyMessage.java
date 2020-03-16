package com.mastery.java.task.ActiveMQ;

public class MyMessage {
    Long id;
    String title;

    public MyMessage(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public MyMessage() {
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
