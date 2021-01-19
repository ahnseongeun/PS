package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 2
9 7 9 1

1 7
1 9
7 9
9 9
비내림차순이다.
 */
public class N과M_10 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static boolean visited[];
    static StringBuilder sb;

    private static void permutation(int start, int index) {
        if(m+1 == index){
            for(int i=1;i <= m ;i++)
                sb.append(result[i]+" ");
            sb.append("\n");
        }
        /*

         */
        int before = -1;
        for(int i = start; i <= n; i++){
            if(visited[i] || before == arr[i])
                continue;
            visited[i] = true;
            before = arr[i];
            result[index] = arr[i];
            permutation(i,index+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        result = new int[n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(input.readLine());
        for(int i=1;i<=n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        Arrays.sort(arr);
        permutation(1,1);
        System.out.println(sb);
    }
}
