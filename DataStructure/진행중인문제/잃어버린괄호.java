package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1번 파싱한다.
 * 2번 - + 구조로 나눈다.
 */
public class 잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        List<Integer> numberList = new ArrayList<>();
        List<Character> operationList = new ArrayList<>();
        int preIdx = 0;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
               numberList.add(Integer.parseInt(str.substring(preIdx,i)));
               operationList.add(str.charAt(i));
               preIdx = i + 1;
            }
        }
        numberList.add(preIdx);
    }
}
