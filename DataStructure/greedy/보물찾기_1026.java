package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
1 1 1 6 0
2 7 8 3 1
 */
public class 보물찾기_1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(input.readLine());
        int result = 0;
        int a[] = new int[n];
        int b[] = new int[n];

        st = new StringTokenizer(input.readLine());
        for(int i = 0;i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        for(int i = 0;i < n; i++) b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < n; i++) result += (a[i] * b[n - i - 1]);
        System.out.println(result);

    }
}
