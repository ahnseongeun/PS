package JAVA.Generic.chapter1_generic기본;

public class Box<T> {
    private T t;

    public T get() { return t; }
    public void set(T t) { this.t = t;}
}
