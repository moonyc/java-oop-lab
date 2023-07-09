package com.mycompany.app;

public class App {
    public static void main( String[] args ) {
        var result = abstractedLogic();
        var record = new Coordinates(0,0,0); 
        var object = new ThreeDCalculator(record);
        System.out.println(result);
        System.out.println(record);
        System.out.println(object);
    }

    public static int abstractedLogic() {

        // logic
        return 1;
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

}