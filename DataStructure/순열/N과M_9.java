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
1 9

1 7
1 9
7 1
7 9
9 1
9 7
9 9
기존에는 input값에 중복이 들어오지 않았다.
input값에 중복이 들어왔을 경우 중복된 경우의 수를 피하는 방법을 구하는 방법은?
중복된 값은 서로 다른 수라고 볼수 있지만 output의 결과가 같은 경우를 피하자.
sort 후에 이전값과 비교해서 같으면 continue;
 */
public class N과M_9 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static boolean visited[];
    static StringBuilder sb;

    private static void permutation(int idx) {
        if(m+1 == idx){
            for(int i=1;i<=m;i++)
                sb.append(result[i]+" ");
            sb.append("\n");
            return;
        }
        /*
        중복을 피하려면??
        sort를 했다면 이전값과 비교하면 되고
        sort를 하지 않았다면 처음부터 방문한 곳을 체크할수 있는 배열을 만들어서 확인해줘야 한다.
         */
        int before=-1;
        for(int i=1;i <= n;i++){
            if(visited[i]||before==arr[i])
                continue;
            visited[i] = true;
            before = arr[i];
            result[idx] = arr[i];
            permutation(idx+1);
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
        permutation(1);
        System.out.println(sb);
    }
}
