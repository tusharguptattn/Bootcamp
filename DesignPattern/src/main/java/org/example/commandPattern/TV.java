package org.example.commandPattern;

public class TV implements Device{

    @Override
    public void turnOn() {
        System.out.println("Turning On");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off");
    }
}
