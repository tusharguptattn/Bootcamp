package org.example.observer;

public class Subscriber {
    private String name;
    private Channel channel;

    public Subscriber(String name){
        this.name = name;
    }

    public void update(){
        System.out.println("Hey " +name +"video uploaded");
    }

    public void subscriberChannel(Channel ch){
        channel = ch;
    }

}
