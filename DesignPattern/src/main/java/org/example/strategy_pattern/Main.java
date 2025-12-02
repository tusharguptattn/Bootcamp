package org.example.strategy_pattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(new NormalDrive());
        vehicle.drive();
    }

}
