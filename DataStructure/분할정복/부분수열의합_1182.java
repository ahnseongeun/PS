package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {

    private static int k;
    private static int[] arr;

    private static int getPermutationMax(int idx, int sum, int n) {
        int result = 0;
        if(idx == n)
            return 0;

        sum += arr[idx];
        if(sum == k)
            result++;

        result += getPermutationMax(idx + 1, sum, n);
        result += getPermutationMax(idx + 1, sum - arr[idx], n);
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(getPermutationMax(0,0,n));

    }
}
