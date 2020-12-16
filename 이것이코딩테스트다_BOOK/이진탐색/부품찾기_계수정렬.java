package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
8 3 7 9 2
3
5 7 9
N개의 제품 (1 <= N <= 1000000)
각 부품은 정수 형태의 고유한 번호 (1 <= 정수 <= 10^6)
손님이 M개의 종류의 부품을 대량 구매 (1 <= M <= 100000)
가게 안에 M개의 부품이 있는지 확인하는 방법 (1 <= 정수 <= 10^6)
 */
public class 부품찾기_계수정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String result="Yes";

        int n = Integer.parseInt(input.readLine());
        boolean item_list[] = new boolean[1000001];
        StringTokenizer st =new StringTokenizer(input.readLine());
        while(st.hasMoreTokens()){
            int idx=Integer.parseInt(st.nextToken());
            item_list[idx] = true;
        }

        int m = Integer.parseInt(input.readLine());
        st=new StringTokenizer(input.readLine());
        while(st.hasMoreTokens()){
            int requestIdx= Integer.parseInt(st.nextToken());
            if(!item_list[requestIdx]){
                System.out.println(requestIdx);
                result="NO";
                break;
            }
        }
        System.out.println(result);
    }
}
