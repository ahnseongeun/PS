package DataStructure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
7
1 6
6 3
3 5
4 1
2 4
4 7
 */
public class 트리의부모찾기_11725 {

    private static int[] bfs(ArrayList<Integer>[] tree) {
        int[] result = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int index = q.poll();
            for(int i = 0; i < tree[index].size(); i++){
                if(result[tree[index].get(i)] != 0) continue;
                result[tree[index].get(i)] = index;
                q.add(tree[index].get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        int[] result = bfs(tree);
        for(int i = 2; i <= 100000; i++) {
            if(result[i] == 0) break;
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
