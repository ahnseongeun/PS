package DataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

/*
여기서 핵심은
( , ) 이다.
(을 만나면 stack에 (의 index를 넣는다.
)을 만나면 index -1 만큼 안에 있는 문자열 출력
33(562(71(9)))
33(562(72(19)8))
a3(5b2(d1(9dc)))
 */
public class 압축_1662_String {
    static String line;
    static StringBuilder sb = new StringBuilder();
    static int[] reverse;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        line = sc.next();
        Stack<Integer> stack = new Stack<>();
        reverse = new int[50];

        //가장 먼저 ( 와 ) 의 위치를 찾을 수 있게 순서쌍을 초기화 한다.
        for(int i=0;i<line.length();i++) {
            if(line.charAt(i)=='(') stack.add(i);
            if(line.charAt(i)==')') reverse[stack.pop()] = i;
        }
        System.out.println(traversal(0,line.length()));
        System.out.println(sb);
    }

    public static String traversal(int start, int end) {

        StringBuilder sb = new StringBuilder();

        // 괄호 안에 괄호 처리 점점 깊은 곳으로 들어가게 끔 접근하는 것이 핵심
        // 괄호를 만나기 전까지는 차레대로 삽입 하다가 괄호를 만나면 해당 괄호를 다시 재귀
        //
        for(int i = start; i<end; i++) {
            if(line.charAt(i)=='(') {
                String st = traversal(i+1,reverse[i]);
                StringBuilder newSt = new StringBuilder();
                /**
                 * 문자열 반복 api st.repeat(line.charAt(i-1) - '0');
                 */
                for(int j = 0; j < (line.charAt(i-1) - '0' ); j++){
                    newSt.append(st);
                }
                sb.append(newSt);
                i = reverse[i];
            } else {
                if(line.charAt(i + 1) == '(')
                    continue;
                sb.append(line.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
