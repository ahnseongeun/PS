package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 첼시를도와줘_11098 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(input.readLine());
            int compare_price = -1;
            String result = "";
            for(int j = 0; j < m; j++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if(compare_price < price) {
                    compare_price = price;
                    result = name;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
