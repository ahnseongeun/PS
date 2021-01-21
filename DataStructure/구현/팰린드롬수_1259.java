package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while(true){
            String str = input.readLine();
            if(str.equals("0"))
                break;
            for(int i = 0;i <= str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                    System.out.println("no");
                    break;
                }
                if(i == str.length()/2)
                    System.out.println("yes");
            }
        }
    }
}
