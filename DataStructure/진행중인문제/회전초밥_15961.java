package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8 30 4 30
7
9
7
30
2
7
9
25
 */
public class 회전초밥_15961 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dish = new int[d + 1];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(input.readLine());
        int result = 0; //결과
        int kind = 0; //먹은 종류의 수

        //초반 윈도우 설정 및 검사
        for(int i = 0; i < k; i++) {
            if(dish[arr[i]] == 0) kind++; //안먹었다면 종류 추가
            dish[arr[i]]++;
        }
        result = kind; //초반 MAX 설정

        //가장 왼쪽 부터 슬라이딩 윈도우 진행
        for(int i = 0; i < n; i++) {

            //앞부분 빼주기
            int value = arr[i];
            dish[value]--;
            if(dish[value] == 0) kind--;

            //뒷부분 추가하기
            value = arr[(i + k) % n];
            dish[value]++;
            if(dish[value] == 1) kind++;

            //먹은 종류가 더 많아지면 쿠폰 반영후 종류 추가
            if(result <= kind) {
                //쿠폰을 사용안했다면
                if(dish[c] == 0) result = kind + 1;
                else result = kind;
            }
        }

        System.out.println(result);
    }
}
