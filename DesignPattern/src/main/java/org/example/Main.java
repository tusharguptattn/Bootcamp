package org.example;

import org.example.builderPattern.User;
import org.example.factoryPattern.Shape;
import org.example.factoryPattern.ShapeFactory;
import org.example.singleton.SingleTon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // SingleTon
        SingleTon instance = SingleTon.getInstance();
        int sum = instance.sum(1, 3);
        System.out.println(sum);


        // Factory

        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();



        // Builder Pattern

        User user = new User.Builder()
                .setName("Sheru")
                .setAge(20)
                .setEmail("tushar@gmail.com").build();
        System.out.println(user);


    }
}