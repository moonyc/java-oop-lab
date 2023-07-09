package com.mycompany.app;

import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.function.Supplier;
import java.util.logging.Level;

public class App {
    public static void main( String[] args ) {
        var result = abstractedLogic();
        var record = new Coordinates(0,0,0); 
        var object = new ThreeDCalculator(record);
        System.out.println(result);
        System.out.println(record);
        System.out.println(object);
        System.out.println(object.translate( new Coordinates(1, 2, 3)));
        System.out.println(logAndReturn(object));
    }

    public static int abstractedLogic() {

        // logic
        return 1;
    }

    public static <T> T logAndReturn(T obj) {
        Logger.getAnonymousLogger().log( new LogRecord( Level.INFO, obj.toString()));
        return obj;
    }

    // supplier : takes nothing and returns T
    // consumer : takes T and returns nothing

    public static <T> Supplier<T> decorateWithLogger(Supplier<T> functionToDecorate) {
        return () -> {
            Logger.getAnonymousLogger().info(
                functionToDecorate.toString()
            );
            return functionToDecorate.get();
        };
    }

}

record Coordinates(int x, int y, int z) {

    }

class ThreeDCalculator {
    private Coordinates origin;

    public ThreeDCalculator(Coordinates origin) {
        this.origin = origin;   
    }

    public Coordinates getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinates origin) {
        this.origin = origin;
    }

    public Coordinates translate(Coordinates transform) {
        return new Coordinates(
            origin.x() + transform.x(),
            origin.y() + transform.y(),
            origin.z() + transform.z()
        );

    }

}