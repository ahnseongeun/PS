package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
public class 부품찾기_set이용 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set=new HashSet<>();
        String result="Yes";
        int result_idx=0;

        int n = Integer.parseInt(input.readLine());
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        for(int i=0;i<m;i++){
            int idx=Integer.parseInt(st.nextToken());
            if(!set.contains(idx)) {
                result="No";
                result_idx=idx;
                break;
            }
        }
        System.out.println(result);
        System.out.println(result_idx);
    }
}
