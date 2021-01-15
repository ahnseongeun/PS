package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

3 1
 */
public class N과M_1 {
    static int n;
    static int m;
    static int arr[];
    static boolean visited[];
    static StringBuilder sb;
    private static void next_permutation(int index){
        if(index==m+1){
            for(int i=1;i < index; i++)
                sb.append(arr[i]+" ");
            sb.append("\n");
            return ;
        }
        /**
         *  4 1 3 2 이런식으로 순열을 만들기 위해서는
         *  next_permutation함수 안에 i = 1로 지정해서 모든 index에 대해서 1~max까지 확인해줘야 한다.
         */
        for(int i = 1;i <= n;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            arr[index]=i;
            next_permutation(index+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb =new StringBuilder();
        arr=new int[n+1];
        visited=new boolean[n+1];
        next_permutation(1); //index
        System.out.println(sb);
    }
}
