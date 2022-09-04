package JAVA.Generic.chapter3_generic_method;

import JAVA.Generic.chapter1_generic기본.Box;

/**
 * <T,R>(재네릭 메소드임을 알림)R(반환 타입)method(T t)(매개변수)
 */
public class Util {

    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }
}
