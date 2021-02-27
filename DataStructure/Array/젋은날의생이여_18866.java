package DataStructure.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 젋은날의생이여_18866 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int arr[][] = new int[n][2];
        int happy[][] = new int[n][2];
        int pirodo[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //최소 행복, 최대 피로도 1 부터 n까지
        int minHappy = Integer.MAX_VALUE;
        int maxPirodo = -1;
        for(int i = 0; i < n; i++){

            if(arr[i][0] != 0)
                minHappy = Math.min(minHappy,arr[i][0]);

            if(arr[i][1] != 0)
                maxPirodo = Math.max(maxPirodo,arr[i][1]);

            happy[i][0] = minHappy;
            happy[i][1] = maxPirodo;
        }

        //최대 행복, 최소 피로도 n 부터 1 까지
        int maxHappy = -1;
        int minPirodo = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0 ; i--){

            if(arr[i][0] != 0)
                maxHappy = Math.max(maxHappy,arr[i][0]);

            if(arr[i][1] != 0)
                minPirodo = Math.min(minPirodo,arr[i][1]);

            pirodo[i][0] = maxHappy;
            pirodo[i][1] = minPirodo;

        }

        int max = -1;
        for(int i = n - 2; i >= 0; i--){
            int preHappy = happy[i][0];
            int prePirodo = happy[i][1];
            int nowHappy = pirodo[i + 1][0];
            int nowPirodo = pirodo[i + 1][1];

            if(preHappy > nowHappy && prePirodo < nowPirodo) {
                max = Math.max(max,i + 1);
            }
        }

        System.out.println(max);

    }
}
