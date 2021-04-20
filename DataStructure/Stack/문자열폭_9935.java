package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/*
첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.
O(N)으로 푸세요~
문자를 넣고 마지막에 걸리면 peek 해보면서 검사
mirkovC4nizCC44
C4
12ab112ab2ab
12ab
 */
public class 문자열폭_9935 {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String reverse = input.readLine();
        StringBuilder sb = new StringBuilder();
        //explosionStr.append(input.readLine());
        //String reverse = explosionStr.reverse().toString();

        Stack<Character> stack = new Stack<>();

        for(int i = str.length() - 1; i >= 0; i--){
            stack.push(str.charAt(i));
            //거꾸로 돌기 때문에 첫번째 문자와 일치하면 스택에서 제외
            if(stack.size() >= reverse.length() && stack.peek() == reverse.charAt(0)){
                int st_idx = stack.size() - 1;
                boolean BoomCheck = false;
                for(int j = 0; j < reverse.length(); j++){
                    //두개의 문자열을 비교하기
                    if(reverse.charAt(j) == stack.get(st_idx--)) {
                        if(j == reverse.length() - 1)
                            BoomCheck = true;
                        continue;
                    }else {
                        break;
                    }
                }
                //문자열 폭발 조건을 만족하면 문자열 stack에서 제외
                if(BoomCheck) {
                    for (int j = 0; j < reverse.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            sb.append("FRULA");
        }else{
            while(!stack.isEmpty())
                sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

/*
        메모리 초과
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String explosionStr = input.readLine();
        while(str.contains(explosionStr)){
            str = str.replaceAll(explosionStr,"");
        }
        System.out.println(str.equals("") ? "FRULA" : str);
 */
