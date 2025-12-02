package Concurrent;

public class SingleTon {

    public static SingleTon singleTon;

    private SingleTon(){

    }
    private static SingleTon getInstance(){
        if(singleTon==null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }



}
