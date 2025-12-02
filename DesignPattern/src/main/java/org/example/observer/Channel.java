package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String title;
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s){
        subscribers.add(s);
    }

    public void unSubscribe(Subscriber s){
        subscribers.remove(s);
    }

    public void notifySubscribers(){
        for (Subscriber s:subscribers){
            s.update();
        }
    }

    public void upload(String title){
        this.title = title;
        notifySubscribers();
    }
}
