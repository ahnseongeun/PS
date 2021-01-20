package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
완전 탐색은 시간 초과가 나왔다.
어떻게 DP로 풀까?
두개의 문자열중 최장길이 공통 문자열을 구하는 방법은
2차원 배열을 이용해서 하나씩 값을 비교해 보면 된다.
 */
public class 공통부분문자열_5582 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str1 = input.readLine();
        String str2 = input.readLine();
        int arr[][] = new int[str1.length()][str2.length()];
        int max = -1;
        for(int i = 0; i < str1.length();i++){
            for(int j = 0; j < str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i == 0||j == 0){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = (arr[i-1][j-1]+1);
                    }
                }
                max = Math.max(arr[i][j],max);
            }
        }

        System.out.println(max);
    }
}
