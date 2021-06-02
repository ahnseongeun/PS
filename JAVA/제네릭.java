package JAVA;

import java.util.ArrayList;
import java.util.Arrays;

public class 제네릭 {
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        list.add("test");
        list.add(1);
        list.add(new int[]{1,2,3});
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());
        System.out.println(list.indexOf("test"));
        System.out.println(list.indexOf(1));
        System.out.println(list.get(2));
        System.out.println(Integer.toBinaryString(2));
        System.out.println();
        int arr[] = {1,2,3};
        int i = Arrays.binarySearch(arr, 2);
        System.out.println(i);


        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        String str = "test";
        String st = "e";

        char ch = 's';
        System.out.println(str.indexOf(st + ch));
        String[] input = {"12:00","12:14","HELLO","CDEFGAB", "13:00","13:05","WORLD","ABCDEF"};
        System.out.println(input[0]);
        System.out.println(input[1]);
    }
}
