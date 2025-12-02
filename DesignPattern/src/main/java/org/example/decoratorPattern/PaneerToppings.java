package org.example.decoratorPattern;

public class PaneerToppings implements ToppingsDecorator{
    private BasePizza basePizza;

    public PaneerToppings(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost()+50;
    }
}
