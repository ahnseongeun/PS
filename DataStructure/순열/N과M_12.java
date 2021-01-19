package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
중복되는 수열을 여러 번 출력하면 안되며
4 2
9 7 9 1

1 1
1 7
1 9
7 7
7 9
9 9
 */
public class N과M_12 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static StringBuilder sb;

    private static void permutation(int start,int index) {
        if(m+1 == index){
            for(int i = 1;i <= m;i++)
                sb.append(result[i]+" ");
            sb.append("\n");
            return;
        }
        int before = -1;
        for(int i = start; i <= n;i++){
            if(before == arr[i])
                continue;
            before = arr[i];
            result[index] = arr[i];
            permutation(i, index+1);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        result = new int[n+1];
        st = new StringTokenizer(input.readLine());
        for(int i=1;i<=n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        Arrays.sort(arr);
        permutation(1,1);
        System.out.println(sb);
    }
}
