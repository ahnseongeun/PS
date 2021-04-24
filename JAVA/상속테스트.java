package JAVA;

abstract class Vehicle{
    String name;
    abstract public String getName(String val);

    public String getName(){
        return "Vehicle name :" + name;
    }
}

class Car extends Vehicle{
public Car(String val){
        name = super.name = val;
        }

public String getName(String val){
        return "Car name :" + val;
        }
public String getName(byte val[]){
        return "Car name :" + val;
        }
        }

class Test{
    public static void main(String[] args){
        Vehicle obj = new Car("Spark");

        System.out.printf(obj.getName());

    }
}
