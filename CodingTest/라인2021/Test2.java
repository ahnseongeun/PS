package CodingTest.라인2021;

import java.util.ArrayList;

/*
1. 2차원 배열로 정리하고
2. 각각 검색어에 대해서 n일 동안 k 번 이상 검색되었는지 확인
3. 2 * n * k 총 일수 보다 n일의 합이 많다면 통과
 */
public class Test2 {

    static int[][] arr;
    static String result = "None";
    static int max = 0;
    static int days;

    private static void check1(int n, int k, int size) {

        for(int i = 0; i < 26; i++) {
            boolean flag = false;
            boolean flag1 = false;
            int cnt = 0;

            for(int j = 0; j <= size - n; j++) {
                int sum = 0;
                for(int l = j; l < j + n; l++) {
                    sum += arr[i][l];
                    if(arr[i][l] >= k) continue;
                    flag = true;
                    break;
                }
                //탈락
                if(!flag) {
                    if (sum >= days) {
                        cnt++;
                    }
                }
            }
            if(cnt > max && !flag) {
                max = cnt;
                result = Character.toString(i + 'a');
            }
        }
    }


    public static void main(String[] args) {
        String[] research = { "yxxy","xxyyy" };
        int n = 2;
        int k = 1;
        int size = research.length;
        days = 2 * n * k;

        arr = new int[26][size];

        for(int i = 0; i < research.length; i++) {
            String word = research[i];
            for(int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                arr[ch - 'a'][i]++;
            }
        }

        //각각 검색어에 대해서 n일 동안 k 번 이상 검색되었는지 확인
        check1(n, k, size);
        System.out.println(result);
    }

}
