package JAVA.java.throws_;

public class test95
{
    private static class FuelException extends Exception {}

    private static class Car {
        int fuel = 3;

        void drive() throws FuelException {
            if( fuel == 0 ) {
                throw new FuelException();
            }
            System.out.println("10KM GOGO");
            fuel--;
        }
    }

    public static void main(String[] args) {
        Car tico = new Car();
        try {
            tico.drive();
            tico.drive();
            tico.drive();
            tico.drive();
        }
        catch( FuelException e ) {
            System.out.println("mango!!! " + e.toString() );
        }

        System.out.println("Goal!!!");
    }
}
