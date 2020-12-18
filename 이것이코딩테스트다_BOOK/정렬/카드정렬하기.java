package 이것이코딩테스트다_BOOK.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 카드정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        int total=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<n;i++)
            q.add(Integer.parseInt(input.readLine()));

        for(int i=0;i<n-1;i++){
            int temp1=q.poll();
            int temp2=q.poll();
            int temp_sum=temp1+temp2;
            q.add(temp_sum);
            total+=(temp_sum);
        }
        System.out.println(total);
    }
}
