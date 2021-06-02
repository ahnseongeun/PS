package JAVA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 문자열파싱 {
    public static void main(String[] args){
        String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String[] strs = str.replaceAll("\\{"," ").replaceAll("}"," ")
        .trim().split(" , ");
        Arrays.stream(strs).forEach(System.out::println);
        Arrays.sort(strs,(o1, o2) -> o1.length() - o2.length());
        Set<String> set = new HashSet<>();
        for(String tmp : strs){
            for(String num : tmp.split(",")){

            }
        }
    }
}
