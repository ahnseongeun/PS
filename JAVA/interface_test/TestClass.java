package JAVA.interface_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


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

        List<Integer> list = Arrays.asList(1,2,3);

        forEach(list, (value) -> {
            value += 1;
            System.out.println(value);
        });

    }
}
