package JAVA.Generic.chapter1_generic기본;

public class Main {
    public static void main(String[] args) {

        Box<Integer> box1 = new Box<>();
        Box<String>  box2 = new Box<>();

        box1.set(5);
        int value1 = box1.get();
        System.out.println(value1);

        box2.set("Hello");
        String value2 = box2.get();
        System.out.println(value2.getClass().getName());

    }
}
