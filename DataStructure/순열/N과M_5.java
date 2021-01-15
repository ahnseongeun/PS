package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class N과M_5 {
    static int arr[];
    static int result[];
    static boolean visited[];
    static int n;
    static int m;
    static StringBuilder sb;

    private static void next_permutation(int idx) {
        if(idx==m+1){
            for(int i=1;i < idx; i++)
                sb.append(result[i]+" ");
            sb.append("\n");
            return ;
        }
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            visited[i]=true;
            result[idx]=arr[i];
            next_permutation(idx+1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        result = new int[n+1];
        st=new StringTokenizer(input.readLine());
        for(int i=1;i<=n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        visited = new boolean[n+1];
        sb = new StringBuilder();
        next_permutation(1);
        System.out.println(sb);
    }
}
