package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1번 파싱한다.
 * 2번 - 이후에 괄호를 치면 최소값이된다
 * - 어떠한 형태가 와도 - 뒤에 괄호를 치면 첫번째수 - 모든 수의 합 이 최소값이 되는 것을 알고 있느냐 하는 문제
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
        numberList.add(Integer.parseInt(str.substring(preIdx)));

        int total = numberList.get(0);
        int sum = 0;
        for(int i = 0; i < operationList.size();i++) {
            if (i + 1 < operationList.size() && operationList.get(i) == '-' && operationList.get(i + 1) == '+') {
                for (int j = i + 1; j < numberList.size(); j++) {
                    sum += numberList.get(j);
                }
                total -= sum;
                break;
            } else {
                if (operationList.get(i) == '+') {
                    total += numberList.get(i + 1);
                } else {
                    total -= numberList.get(i + 1);
                }
            }
        }
        System.out.println(total);
    }
}
