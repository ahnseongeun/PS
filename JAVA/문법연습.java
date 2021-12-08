package JAVA;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class 문법연습 {


    public static void main(String[] args){
        
        String test1 = "sdf";
        System.out.println(test1 + 3);
        String str_test1 = "test";
        String str_test2 = "test";
        String str_test3 = new String("test");
        System.out.println(str_test1);
        System.out.println(str_test1 == str_test2);
        System.out.println(str_test1 == str_test3);
        System.out.println(str_test1 == str_test3.intern());
//        HashMap<Integer,String> map = new HashMap<>();
//        map.put(1,"String");
////        String str1 = "abcd";
////        String str2 = "abc";
////        System.out.println(str1.startsWith(str2));
////        String[] books = {"ab","abd","abc"};
//        for(String book : books){
//            map.keySet();
//        }
        Queue<int[]> q = new LinkedList<>();
        Iterator<int[]> iterator = q.iterator();
        while(iterator.hasNext()){
            int tmp[] = iterator.next();
            System.out.println(tmp.length);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int arr[] = {1,2,3};
        int brr[] = Arrays.copyOfRange(arr,2,5);
        Iterator<Integer> iter = pq.iterator();
        pq.peek();
        int ar[][] = new int[1][1];
        int len = ar.length;
        int tmp[] = Arrays.copyOfRange(arr,0,1);
        System.out.println(tmp.length);
        StringBuilder sb = new StringBuilder();
        sb.append(123);
//        int a = Integer.parseInt(sb.toString());
//        int b= 2;
//        System.out.println(Math.max(a,b));

        int numbers[] ={6,10,2};
        String answer = "";
        LinkedList<Integer> list = new LinkedList<>();
        for(int number : numbers)
            list.add(number);
        //sort
        Collections.sort(list,(a,b) ->{
            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            return (str2+str1).compareTo(str1+str2);
        });
        list.forEach(System.out::println);
        ArrayList<Integer> list1 = new ArrayList<>();
        //str = str.substring(2);
        HashMap<Character,Integer> map = new HashMap<>();
        //map.put('a',map.getOrDefault(key,0) + 1);
        Iterator<Integer> iterator1 = list1.iterator();
        while(list.iterator().hasNext()){

        }
    }
}
