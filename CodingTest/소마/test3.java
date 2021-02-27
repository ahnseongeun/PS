package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test3 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num] = 1;
        }
        int count = 0;
        int left_idx = start;
        int left_lastIdx = start;
        int right_idx = start;
        int right_lastIdx = start;
        if(arr[start] == 1)
            count++;
        while(true){
            if(left_idx == 1){
                if(arr[left_idx] == 1) {
                    count++;
                    left_lastIdx = left_idx;
                }
            }else{
                if(left_idx - 1 > 0){
                    left_idx -= 1;
                    if(arr[left_idx] == 1) {
                        count++;
                        left_lastIdx = left_idx;
                    }
                }
            }
            if(count == m)
                break;

            if(right_idx == 10000){
                if(arr[right_idx] == 1) {
                    count++;
                    right_lastIdx = right_idx;
                }
            }else{
                if(right_idx + 1 < 10001){
                    right_idx += 1;
                    if(arr[right_idx] == 1) {
                        count++;
                        right_lastIdx = right_idx;
                    }
                }
            }
            if(count == m)
                break;
        }
        System.out.println((start - left_lastIdx) + (right_lastIdx - start) );
    }
}
/**
 입력
 첫 번째 줄에 땅콩의 개수 NN, 먹으려는 땅콩 개수 MM, 그리고 소마의 위치 EE 순으로 공백을 구분자로 입력받는다. (NN, MM 그리고 EE는 정수이다.)
 1 ≦ N ≦ 10,000
 1≦N≦10,000
 1 ≦ M ≦ N
 1≦M≦N

 두 번째 줄에 N개의 숫자에 대하여 땅콩이 있는 위치를 공백을 구분자로 입력받는다. (땅콩의 위치는 정수이다.)

 두 개의 땅콩이 같은 위치에 있는 예시는 입력되지 않으며 땅콩의 위치는 오름차순으로 입력된다.

 소마의 위치와 땅콩의 위치가 겹치는 경우 소마는 움직이지 않고 땅콩을 바로 먹을 수 있다.

 출력
 소마가 땅콩을 먹으려 할 때 그려지게 될 빨간 선 중 최소 길이를 출력한다.
 입력 예시
 6 3 7
 2 4 5 8 11 12
 Copy
 출력 예시
 4
 */