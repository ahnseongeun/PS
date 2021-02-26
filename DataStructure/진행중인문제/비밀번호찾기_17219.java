package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기_17219 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();

        for(int i = 0;i < n ; i++){
            st = new StringTokenizer(input.readLine());
            map.put(st.nextToken(),st.nextToken());
        }
        for(int i = 0;i < m ; i++)
            sb.append(map.get(input.readLine())).append("\n");
        System.out.println(sb);
    }
}
