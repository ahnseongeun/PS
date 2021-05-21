package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
cat tree tcraete
cat tree catrtee
cat tree cttaree
 */
public class 단어섞기_bfs_9177 {


    private static String bfs(String str1, String str2, String target) {

        boolean dp[][] = new boolean[201][201];
        boolean result[] = new boolean[401];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] index = q.poll();
            int idx1 = index[0];
            int idx2 = index[1];

            if(idx1 < str1.length() && str1.charAt(idx1) == target.charAt(idx1 + idx2) && !dp[idx1 + 1][idx2]) {
                q.add(new int[]{idx1 + 1, idx2});
                result[idx1 + idx2] = true;
                dp[idx1 + 1][idx2] = true;
            }

            if(idx2 < str2.length() && str2.charAt(idx2) == target.charAt(idx1 + idx2) && !dp[idx1][idx2 + 1]) {
                q.add(new int[]{idx1, idx2 + 1});
                result[idx1 + idx2] = true;
                dp[idx1][idx2 + 1] = true;
            }

        }
        if(result[target.length() - 1])
            return "yes";
        return "no";
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String target = st.nextToken();
            sb.append("Data set ").append(i + 1).append(": ").append(bfs(str1,str2,target)).append("\n");
        }
        System.out.println(sb);
    }
}
