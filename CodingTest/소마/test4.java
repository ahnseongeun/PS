package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test4 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean visited[];
        int max = -1;
        for(int i = 1; i <= 3 ;i++){
            visited = new boolean[n + 1];
            int count = 1;
            int next_idx = i;
            visited[next_idx] = true;
            for(int j = 1; j <= n; j++){
                next_idx += arr[next_idx];
                count++;
                if(visited[next_idx])
                    break;
                visited[next_idx] = true;
            }
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}
