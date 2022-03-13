package CodingTest.가비아;

import java.util.Stack;

/*
<<>>
*/
public class Test2 {
    public static int solution(String str) {

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if( ch == '>') break;
            leftCount++;
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if( ch == '<') break;
            rightCount++;
        }

        return leftCount + rightCount;
    }

    public static void main(String[] args) throws Exception {
      String input = "<<<><";
      System.out.println(solution(input));
    }
}
