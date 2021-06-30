package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 농구경기_1159 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            char ch = input.readLine().charAt(0);
            if (map.get(ch) == null) {
                map.put(ch,1);
            } else {
                map.put(ch,map.get(ch) + 1);
            }
        }
        for(char key : map.keySet()) if(map.get(key) >= 5) sb.append(key);
        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}
