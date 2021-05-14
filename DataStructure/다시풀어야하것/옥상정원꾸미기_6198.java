package DataStructure.다시풀어야하것;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
6
10
3
7
4
12
2
 */
/*
5
5
4
3
2
1
 */

/**
 * 배열에서 순서대로 점검할 때 특정원소에서 다음 특정 원소사이의 내림차순을 구하기 위해서
 * Stack을 사용하면 O(n)에 근접하게게문제를 풀 수 있다.
 */
public class 옥상정원꾸미기_6198 {

    private static long getCheckHeight(int[] building) {

        long cnt = 0;
        Stack<Long> stack = new Stack<>();

        for(int i = 0; i < building.length ; i++){
            long height = building[i];
            while(!stack.isEmpty() && stack.peek() <= height)
                stack.pop();
            stack.push(height);
            cnt += stack.size() - 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] building = new int[n];
        for(int i = 0; i < n; i++)
            building[i] = Integer.parseInt(input.readLine());
        System.out.println(getCheckHeight(building));
    }
}
