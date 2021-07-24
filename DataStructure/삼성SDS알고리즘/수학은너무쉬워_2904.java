package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 에라토스테네스의 체를 이용해서 소수 찾기
 * 2. 주어진 원소들 소인수 분해하기
 * 3. 소인수 분해된 수들을 숫자 별로 카운팅 하기
 * 4. N으로 나눠 배분 법칙
 * 5. 소인수 분해한 결과와 배분 법칙을 이용해서 가능 여부 및 이동 카운트 정하기ㅣ
 */

/**
 * N의 원소의 값의 최대가 1000000이여서  1000000이하의 소수를 찾자.
 */
public class 수학은너무쉬워_2904 {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        boolean[] checked = new boolean[1000001];
        //에라토스테네스의 체로 소수 찾기
        for(int i = 2; i < 1000001; i++) {
            if(checked[i]) continue;
            list.add(i);
            for(int j = i + i; j < 1000001; j += i){
                checked[j] = true;
            }
        }


    }
}
