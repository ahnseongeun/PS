package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 2
9 8 7 1

1 1
1 7
1 8
1 9
7 7
7 8
7 9
8 8
8 9
9 9
//비내림차순, start 변수 필요
 */
public class N과M_8 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static StringBuilder sb;

    private static void permutation(int start,int idx) {
        if(m+1 == idx){
            for(int i=1;i<=m;i++)
                sb.append(result[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=start;i <= n;i++){
            result[idx] = arr[i];
            permutation(i,idx+1);
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
