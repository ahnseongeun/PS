package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UCPC는무엇의약자일까_15904 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
        String str = input.readLine();
        String target = "UCPC";
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(index == target.length()) break;
            if(target.charAt(index) == ch) index++;
        }
        if(index == target.length()) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }
}
