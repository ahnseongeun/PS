package JAVA;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class 자바문법연습 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("String");
        list1.remove(0);

        String str = "test";
        str.length();
        str.indexOf("s",1);
        str.substring(0,2);

        Stack<String> stack = new Stack<>();
        stack.push("test1");
        stack.pop();

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        pq.add("test1");

        System.out.println("string1".compareTo("string2"));
        System.out.println("string1".compareTo("string1"));
        System.out.println("string2".compareTo("string1"));
    }
}
