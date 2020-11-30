package JAVA;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList와Linkedlist비교 {
    public static void main(String[] args){
        ArrayList<Integer> list1=new ArrayList<>();
        LinkedList<Integer> list2=new LinkedList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);
        list1.remove(0);
        System.out.println(list1);

    }
}
