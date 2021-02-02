package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0;i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int m = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        for(int i = 0;i < m ; i++){
            int var = Integer.parseInt(st.nextToken());
            sb.append(map.get(var) == null? 0 : map.get(var)).append(" ");
        }
        System.out.println(sb);
    }
}
