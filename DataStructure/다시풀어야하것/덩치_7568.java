package DataStructure.다시풀어야하것;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
55 185
58 183
88 186
60 175
46 155

2 2 1 2 5
 */

public class 덩치_7568 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int arr[][] = new int[n][2]; //몸무게, 키, 덩치 순서,인덱스번호
        int result[]=new int[n];
        for(int i = 0;i < n;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i < n;i++){
            int rank=1;
            for(int j = 0;j < n;j++){ //
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){
                    rank++;
                }
            }
            sb.append(rank+"\n");
        }
        /*
        2 2 1 2 5
         */
        System.out.println(sb);
//        for(int i=0;i<n;i++)
//            sb.append(result[i]+" ");
//
//        System.out.println(sb);
    }
}
