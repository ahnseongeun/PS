package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 하얀칸_1100 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for(int i = 0; i < 8; i++){
            String str = input.readLine();
            for(int j = 0; j < 8; j++) if(( i % 2 ==  j % 2 ) && str.charAt(j) == 'F') result++;
        }
        System.out.println(result);
    }
}
