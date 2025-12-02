package org.example.decoratorPattern;

public class ExtraCheese implements ToppingsDecorator{

    private BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza){
        this.basePizza=basePizza;
    }


    @Override
    public int cost() {
        return basePizza.cost()+20;
    }
}
