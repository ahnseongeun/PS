package HackerRanker.Day29;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * T와 N 은 1보다 크고 1000보다 작다.
 */
public class Day29 {
    private static int[] HexToBinary(int num){
        int arr[]=new int[10];
        int cnt= arr.length-1;
        while(num!=1){
            arr[cnt]=num%2;
            cnt--;
            num/=2;
        }
        arr[cnt]=num;
        return arr;
    }

    private static int compareBits(int[] a, int[] b) {
        int total = 0;
        for (int i = a.length - 1, cnt = 0; i >= 0; i--, cnt++) {
                total += ((a[i] & b[i]) * (int) Math.pow(2, cnt));
        }
        return total;
    }
//    int a[] = HexToBinary(i);
//    int b[] = HexToBinary(j);
//    int temp = compareBits(a,b);
    //int temp= i&j;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            int max = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int a[] = HexToBinary(i);
                    int b[] = HexToBinary(j);
                    int temp = compareBits(a,b);
                    if(temp>max&&temp<k)
                        max=temp;
                }
            }
            System.out.println(max);
        }
        scanner.close();
    }
}

