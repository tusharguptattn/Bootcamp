package org.example.strategy_pattern;

public class NormalVehicle extends Vehicle{
    public NormalVehicle(){
        super(new NormalDrive());
    }
}
