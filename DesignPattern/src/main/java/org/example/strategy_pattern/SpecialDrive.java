package org.example.strategy_pattern;

public class SpecialDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sporty Drive");
    }
}
