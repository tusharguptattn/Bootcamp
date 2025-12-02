package org.example.observer;

public class Youtube {
    public static void main(String[] args) {

        Subscriber s1 = new Subscriber("A");
        Subscriber s2 = new Subscriber("B");
        Subscriber s3 = new Subscriber("C");
        Subscriber s4 = new Subscriber("D");
        Subscriber s5 = new Subscriber("E");

        Channel channel = new Channel();
        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);
        channel.subscribe(s4);
        channel.subscribe(s5);

        channel.upload("How to learn java");



    }
}
