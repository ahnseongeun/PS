package JAVA.interface_test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;


public class TestClass {

    public static  <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t: list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {

        // 이런식으로 익명 클래스를 만들어버려서 구현할 수 있다.
        TestInterface testInterface = (value) -> System.out.println(value);
        testInterface.test(3);

        String str = "zte";
        char t = 'a';
        System.out.println(t + 1);

        String[] strs = {"i", "drink", "water"};
        String[] strs1= {"i", "drink", "water"};
        List<String> list = Arrays.asList(strs);
        Queue<String> q = new LinkedList<>(list);
//        List<Integer> list = Arrays.asList(1,2,3);

        forEach(list, (value) -> {
            value += 1;
            System.out.println(value);
        });
    }
}
