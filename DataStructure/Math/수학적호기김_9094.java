package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
10 1
20 3
30 4
(a2+b2+m)/(ab)
 */
public class 수학적호기김_9094 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int t = Integer.parseInt(input.readLine());
        for(int i = 0; i <t ; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for(int b = 1; b < n; b++){
                for(int a = 1; a < b; a++){
                    double num = (Math.pow(a,2) + Math.pow(b,2) + m) / (a * b);
                    if(num == (int)num)
                        count++;
                }
            }
            sb.append(count + "\n");
            count = 0;
        }
        System.out.println(sb);
    }
}
