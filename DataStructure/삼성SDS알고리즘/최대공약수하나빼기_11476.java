package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 누적합은 left에서 하나씩 누적 한 값과, right에서 하나씩 누적 한 값을 이용해서 해결하는 방향을 생각하자.
 */
/*
5
8 12 24 36 48
8  4  4  4  4
4 12 12 12 48
 */
public class 최대공약수하나빼기_11476 {

    private static int[] leftToRight;
    private static int[] rightToLeft;
    private static int[] arr;
    private static int n;
    private static int getMax(int index, int max) {

        int result = -1;
        //gcdResult
        if(index == 0) {
            result = rightToLeft[1];
        } else if( index == n - 1) {
            result = leftToRight[n - 2];
        } else {
            result = gcd(leftToRight[index - 1], rightToLeft[index + 1]);
        }

        if(arr[index] % result == 0) return -1;
        if(max < result) {
            max = result;
        }

        return max;
    }

    private static int gcd(int a, int b) {

        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        arr = new int[n];
        leftToRight = new int[n];
        rightToLeft = new int[n];
        for( int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        //leftToRight
        leftToRight[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftToRight[i] = gcd(arr[i], leftToRight[i - 1]);
        }

        //RightToLeft
        rightToLeft[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightToLeft[i] = gcd(arr[i], rightToLeft[i + 1]);
        }

        //TotalResult
        int maxValue = -1;
        int maxIndex = -1;
        for(int i = 0; i < n; i++) {
            int max = getMax(i, maxValue);
            if(max > maxValue) {
                maxValue = max;
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxValue);
        if(maxIndex != -1) sb.append(" ").append(arr[maxIndex]);
        System.out.println(sb);
    }
}
