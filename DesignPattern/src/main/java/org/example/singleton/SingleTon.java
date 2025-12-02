package org.example.singleton;

public class SingleTon {

    public static SingleTon instance;

    private SingleTon(){}

    public static SingleTon getInstance(){
        if (instance == null){
            instance = new SingleTon();
        }
        return instance;
    }


    public int sum(int a,int b){
        return a+b;
    }
}
