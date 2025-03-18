package io.pavan.singleton;

public class Singleton {
    private Singleton(){
        System.out.println("Reference");
    }
    private static Singleton instance;

    static Singleton getInstance(){
        if(instance==null)
            instance = new Singleton();
        return instance;
    }

}
