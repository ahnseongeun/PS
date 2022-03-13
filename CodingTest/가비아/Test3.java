package CodingTest.가비아;

import java.util.Arrays;

public class Test3 {

    private static int result = 0;
    private static int k = 1;
    private static int t = 1;
    private static StringBuilder sb = new StringBuilder();

    private static void combination(int[] arr, int idx, int level, int sum) {
        if ( level >= k && sum <= t) {
            System.out.println(level + " " + sum);
            result += 1;
        }
        if ( level == arr.length) return;
        for(int i = idx; i < arr.length; i++) {
            combination(arr, i + 1, level + 1, sum + arr[i]);
        }
    }

    private static void solution(int[] arr) {
        Arrays.sort(arr);

        combination(arr, 0, 0,0); //index, count
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1};
        solution(arr);
        System.out.println(result);
    }
}
