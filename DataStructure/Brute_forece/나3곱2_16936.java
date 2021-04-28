package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
6
4 8 6 3 12 9
 */
public class 나3곱2_16936 {
    private static long result[];
    private static long arr[];
    private static int n;
    private static boolean flag = false;
    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        Set<Long> set = new HashSet<>();
        arr= new long[n];
        for(int i = 0; i < n; i++) {
            Long num = Long.parseLong(st.nextToken());
            arr[i] = num;
            set.add(num);
        }

        result = new long[n];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            checkPermutation(0,arr[i],set);
            if(flag) {
                Arrays.stream(result).forEach(value -> sb.append(value).append(" "));
                break;
            }
//            if(checkPermutation(0,arr[i],set)) {
//                Arrays.stream(result).forEach(value -> sb.append(value).append(" "));
//                break;
//            }
        }
        System.out.println(sb);
    }

    private static void checkPermutation(int idx, long num, Set<Long> set) {

        if(n == idx) {
            flag = true;
            return;
        }

        if(set.contains(num)) {
            result[idx] = num;
            if(num % 3 == 0)
                checkPermutation(idx + 1, num / 3, set);
            checkPermutation(idx + 1, num * 2, set);
        }
    }
}
