package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
 */
public class 로또_6603 {

    private static int n;
    private static int arr[];
    private static int result[];
    private static StringBuilder sb;

    private static void permutation(int idx, int index) {
        if(index == 7){
            display();
            return;
        }
        for(int i = idx; i <= n; i++){
            result[index] = arr[i];
            permutation(i + 1,index + 1);
        }
    }

    private static void display() {
        for(int i = 1; i <= 6; i++)
            sb.append(result[i] + " ");
        sb.append("\n");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());


            if(n == 0)
                break;

            arr = new int[n + 1];
            result = new int[7];
            for(int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            permutation(1,1);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
