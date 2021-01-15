package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class N과M_2 {
    static int arr[];
    static boolean visited[];
    static int n;
    static int m;
    static StringBuilder sb;

    //오름 차순을 하기 위해서는 start_idx를 지정해줄 필요가있다.
    //원소의 위치만 나타내는 idx만 사용하면
    // 3 2처럼 low_bound가 원소의 개수여서 첫번째 원소가 3이여도 두번째 원소는 2부터 검사한다.
    private static void next_permutation(int start,int idx) {
        if(idx==m+1){

            for(int i=1;i < idx; i++)
                sb.append(arr[i]+" ");
            sb.append("\n");
            return ;
        }

        for(int i = start;i <= n; i++){
            if(visited[i])
                continue;
            visited[i]=true;
            arr[idx]=i;
            next_permutation(i,idx+1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        visited = new boolean[n+1];
        sb = new StringBuilder();
        next_permutation(1,1);
        System.out.println(sb);
    }
}
