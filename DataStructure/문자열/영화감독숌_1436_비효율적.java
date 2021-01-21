package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 특정수가 들어가는 순서에 맞게 작은 수 부터 수를 구하는 방법
 * 1666 3666 5666 6661 6662 7666
 * 666을 어떻게 브루투 포스?
 */
public class 영화감독숌_1436_비효율적 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int count = 0;
        String str = "666";
        //왼쪽 수가 더 작다면 -1, 크다면 1
        while(true){
            if(str.contains("666"))
                count++;
            if(count == n)
                break;
            int num = Integer.parseInt(str)+1;
            str = String.valueOf(num);
        }
        System.out.println(str);
    }
}
