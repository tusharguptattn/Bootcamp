package org.example.decoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new Margherita();
        BasePizza extraCheese = new ExtraCheese(basePizza);
        BasePizza paneerToppings = new PaneerToppings(extraCheese);
        System.out.println(paneerToppings.cost());

    }
}
