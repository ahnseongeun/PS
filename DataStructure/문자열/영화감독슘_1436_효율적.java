package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//1466659
public class 영화감독슘_1436_효율적 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int start = 666;
        int count = 0;
        while(true){
            int var = start;

            while(var > 0){
                //뒤에 세자리 검사
                if(var % 1000 == 666) {
                    count++;
                    break;
                }
                //뒤에 한자리 떨구기
                var /= 10;
            }
            if(count == n)
                break;
            start++;
        }
        System.out.println(start);
    }
}
