package JAVA.java.throws_;

public class test94 {
    //	널널한 예외??
    private static class FuelException extends RuntimeException {}

    private static class Car {
        int fuel = 3;
        void drive() {
            if( fuel == 0 ) {
                throw new FuelException();
            }
            System.out.println("10KM GOGO");
            fuel--;
        }
    }

    public static void main(String[] args) {
        Car tico = new Car();
        tico.drive();
        tico.drive();
        tico.drive();
        tico.drive();
        System.out.println("Goal!!!");
    }
}
