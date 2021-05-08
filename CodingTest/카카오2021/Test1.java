package CodingTest.카카오2021;

import java.util.*;

class Test1 {

    private static void init(HashMap<String,Integer> map){
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        init(map);

        String str = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch - '0' >= 0 && ch - '0' <= 9){
                sb.append(ch);
            }else{
                str += ch;
            }
            if(map.get(str) != null){
                sb.append(map.get(str));
                str = "";
            }
        }
        return Integer.parseInt(sb.toString());
    }
}