package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FourSquares {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());

        int i = 1;
        while(true){

            while(true){
                if(n < i * i){
                    break;
                }else{
                    i++;
                }
            }
        }
    }
}
