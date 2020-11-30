package HackerRanker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day6 {

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(input.readLine());
        for(int i=0;i<n;i++){
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            String s= input.readLine();
            for(int j=0;j<s.length();j++){
                if(j%2==0) {
                    sb1.append(s.charAt(j));
                }
                else{
                    sb2.append(s.charAt(j));
                }

            }
            System.out.println(sb1+" "+sb2);
        }
    }
}
