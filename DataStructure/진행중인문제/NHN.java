package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NHN {

    static int arr[];
    static boolean visited[];
    static int count = 0;
    private static void permutation(int index, int n, int[][] conflict){
        if(index == 9){
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                int s = conflict[i][0];
                int e = conflict[i][1];
                for(int j = 1; j <= 7; j++) {
                    if(arr[j] == s && arr[j + 1] == e) {
                        return;
                    }
                    if(arr[j] == e && arr[j + 1] == s) {
                        return;
                    }
                }
            }
            count++;
            return;
        }
        /**
         *  4 1 3 2 이런식으로 순열을 만들기 위해서는
         *  next_permutation함수 안에 i = 1로 지정해서 모든 index에 대해서 1~max까지 확인해줘야 한다.
         */
        for(int i = 1;i <= 8;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            arr[index]=i;
            permutation(index+1, n, conflict);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[][] conflict = new int[4][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            conflict[i][0] = Integer.parseInt(st.nextToken());
            conflict[i][1] = Integer.parseInt(st.nextToken());
        }

        arr = new int[9];
        visited = new boolean[9];
        permutation(1, n, conflict);
        System.out.println(count);
    }
}
