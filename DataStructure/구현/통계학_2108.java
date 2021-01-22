package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class 통계학_2108 {
    private static int  max_min(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1] - arr[0];
    }

    private static int  countMax(int[] arr) {
        //중복된 수를 count하고 가장 다루기 쉽게 만드는 자료구조는?

        return 1;
    }

    private static int  midValue(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    private static int arithmeticMean(int[] arr) {
        int sum = 0;
        int size = arr.length;
        for(int num:arr)
            sum += num;
        sum /= size;
        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(input.readLine());

        sb.append(arithmeticMean(arr)+"\n");
        sb.append(midValue(arr)+"\n");
        sb.append(countMax(arr)+"\n");
        sb.append(max_min(arr)+"\n");
    }
}
