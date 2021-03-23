package CodingTest.라인;

import java.util.HashMap;
import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args){
        String inp_str = "AaTa+!12-3";
        LinkedList<Integer> list = new LinkedList<>();

        //길이
        if(8 > inp_str.length() || 15 < inp_str.length())
            list.add(1);

        boolean check[] = new boolean[4];
        boolean flag = false;
        for(int i = 0; i < inp_str.length(); i++){
            char ch = inp_str.charAt(i);
            // 소문자
            if('a' <= ch && 'z' >= ch){
                check[0] = true;
            }else if ('A' <= ch && 'Z' >= ch){
                check[1] = true;
            }else if ('0' <= ch && '9' >= ch){
                check[2] = true;
            }else if (inp_str.indexOf(i) != -1){
                check[3] = true;
            }else{
                if(!flag)
                    list.add(2);
                flag = true;
            }
        }

        //대, 소 , 숫, 특수 중 3개 만족
        int count= 0;
        for(int i = 0 ;i < 4; i++){
            if(check[i])
                count++;
        }
        if(count < 3)
            list.add(3);

        //같은 문자 4개 이상 연속
        for(int i = 0 ; i < inp_str.length(); i++){
            char ch = inp_str.charAt(i);
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ;j < 4; j++)
                sb.append(ch);
            if(inp_str.contains(sb.toString())) {
                list.add(4);
                break;
            }
        }

        HashMap<Character,Integer> map = new HashMap<>();
        //같은 문자 5개 포함
        for(int i = 0 ; i < inp_str.length(); i++){
            char ch = inp_str.charAt(i);
            int cnt = map.getOrDefault(ch,0) + 1;
            if(cnt >= 5){
                list.add(5);
                break;
            }
            map.put(ch, cnt);
        }
        if(list.size() == 0)
            list.add(0);
        System.out.println(list);
    }
}
