package DataStructure.순열;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 2
9 8 7 1

1 7
1 8
1 9
7 8
7 9
8 9
 */
public class N과M_6 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static boolean visited[];
    static StringBuilder sb;
    // 1 7 8 9
    private static void search(int start, int index) {

        if(m+1==index){
            for(int i=1;i<=m;i++)
                sb.append(result[i]+" ");
            sb.append("\n");
        }

        for(int i = start; i <= n; i++){
            if(visited[i])
                continue;
            visited[i]=true;
            result[index]=arr[i];
            search(i,index+1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        st = new StringTokenizer(input.readLine());
        arr=new int[n+1];
        result=new int[n+1];
        visited=new boolean[n+1];
        for(int i=1;i<=n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        search(1,1);
        System.out.println(sb);
    }
}
