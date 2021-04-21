package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
657 3
7 5 1

10 3
9 5 2
 */
public class 큰수구성하기_18511 {

    private static int arr[];
    private static int n, target;

    private static void search(int sum) {
        //목표 값이 n보다 크다면 return
        if(sum > n)
            return;
        //sum이 목표값 보다 크다면 목표 값 = sum
        if(target < sum)
            target = sum;
        //sum + arr[i]
        for(int i = 0; i < arr.length; i++){
            search(sum * 10 + arr[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        target = 0;
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        arr = new int[k];
        for(int i = 0; i < k ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        search(0);
        System.out.println(target);
    }
}
