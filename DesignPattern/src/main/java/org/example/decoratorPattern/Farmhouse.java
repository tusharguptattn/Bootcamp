package org.example.decoratorPattern;

public class Farmhouse implements BasePizza{


    @Override
    public int cost() {
        return 300;
    }
}
