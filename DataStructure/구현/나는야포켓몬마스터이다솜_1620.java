package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_1620 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map1 = new HashMap<>();

        for(int i = 0; i < n; i++){
            String name = input.readLine();
            map.put(name,i+1);
            map1.put(i+1,name);
        }
        
        for(int i = 0; i < m; i++){
            String request = input.readLine();
            String result = null;
            if(type(request)){ //true 면 int
                int num = Integer.parseInt(request);
                result = map1.get(num);
            }else{ //false 면 String
                result = String.valueOf(map.get(request));
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean type(String request) {
        try{
            Integer.parseInt(request);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
