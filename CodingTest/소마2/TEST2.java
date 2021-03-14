package CodingTest.소마2;

import JAVA.문자열_TO_INT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10
3 5 -1 -2 4 4 3 -2 -3 -2
5
3 -1 1 1 -3
5
1 1 1 1 -4
2
1 -1
 */
public class TEST2 {

    private static int visited[];
    private static int n;

    private static void display(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++)
            sb.append(visited[i]+" ");
        System.out.println(sb);
    }
    private static int maxMove(int[] arr, int start) {

        int count = 0;
        while(true){
            if(visited[start] == 3)
                return (int) Arrays.stream(visited).filter(value -> value == 3)
                        .count();
            visited[start]++;
            start += arr[start];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(input.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int i = 0; i < n; i++){
            visited = new int[n];
            max = Math.max(max,maxMove(arr, i));
            //display();
        }
        System.out.println(max);
    }
}