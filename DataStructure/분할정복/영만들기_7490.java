package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
2
3
7
 */

/**
 * 문제해결법은 어떻게 ' '을 처리하는 방법이다.
 *
 */
public class 영만들기_7490 {
    private static int k;
    private static StringBuilder sb;

    private static void makeZero(int idx,String str) {
        if(idx == k){
            String tmp = str.replace(" ","");
            if(getSum(tmp) == 0)
                sb.append(str + "\n");
            return;
        }

        makeZero(idx + 1,str + " " + (idx + 1));

        makeZero(idx + 1,str + "+" + (idx + 1));

        makeZero(idx + 1,str + "-" + (idx + 1));
    }

    private static int getSum(String str) {
        List<Integer> numList = new ArrayList<>();
        List<Character> operList = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-'){
                operList.add(ch);
                numList.add(num);
                num = 0;
            }else{
                num *= 10;
                num += (ch - '0');
            }
        }
        numList.add(num);
        int sum = numList.remove(0);
        for(char oper : operList){
            if(oper == '+'){
                sum += numList.remove(0);
            }else{
                sum -= numList.remove(0);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            k = Integer.parseInt(input.readLine());
            makeZero(1,"1");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
