package org.example.strategy_pattern;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle(){
        super(new SpecialDrive());
    }
}
