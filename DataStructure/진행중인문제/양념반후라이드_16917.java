package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1500 2000 500 90000 100000
 */
public class 양념반후라이드_16917 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int yangnum_price = Integer.parseInt(st.nextToken());
        int pride_price = Integer.parseInt(st.nextToken());
        int divide_price = Integer.parseInt(st.nextToken());
        int yangnum_count = Integer.parseInt(st.nextToken());
        int pride_count = Integer.parseInt(st.nextToken());
        long total = 0;

        //1마리 만드는 가격 비교
        int price = Math.min(yangnum_price + pride_price , divide_price * 2);

        //양념과 후라이드 중에 더적은 가격 찾기
        int count = Math.min(yangnum_count,pride_count);
        total += price * count;
        yangnum_count -= count;
        pride_count -= count;

        //1마리 만드는 가격 비교
        pride_price = Math.min(pride_price, divide_price * 2);
        //1마리 만드는 가격 비교
        yangnum_price = Math.min(yangnum_price, divide_price * 2);
        //더해주기
        total += pride_price * pride_count;
        total += yangnum_price * yangnum_count;
        System.out.println(total);


    }
}
