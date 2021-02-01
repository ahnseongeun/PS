package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int count = 0;
        while(n % 5 != 0){
            if(n == 4) {
                count = -1;
                break;
            }
            n -= 3;
            count++;
        }
        count += n/5;
        System.out.println(count);
    }
}
