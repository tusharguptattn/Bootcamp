package org.example.strategy_pattern;

public class SportsVehicle extends Vehicle{

    public SportsVehicle(){
        super(new SpecialDrive());
    }
}
