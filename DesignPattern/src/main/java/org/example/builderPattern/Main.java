package org.example.builderPattern;

public class Main {

    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Sheru")
                .setAge(20)
                .setEmail("tushar@gmail.com").build();
        System.out.println(user);
    }
}
