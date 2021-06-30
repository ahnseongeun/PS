package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
AABCDD
afzz
09121
a8EWg6
P5h3kx
 */
public class 세로읽기_10798 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] words = new char[5][15];
        for(int i = 0; i < 5; i++) {
            String str = input.readLine();
            for(int j = 0; j < str.length(); j++) words[i][j] = str.charAt(j);
            for(int j = str.length(); j < 15; j++) words[i][j] = '.';
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(words[j][i] != '.') sb.append(words[j][i]);
            }
        }
        System.out.println(sb);
    }
}
