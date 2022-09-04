package JAVA.Generic.chapter3_generic_method;

import JAVA.Generic.chapter1_generic기본.Box;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.get();

        Box<String> box2 = Util.boxing("Hello");
        String stringValue = box2.get();

        System.out.println(intValue);
        System.out.println(stringValue);

    }
}
