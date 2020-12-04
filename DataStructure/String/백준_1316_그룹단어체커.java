package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 백준_1316_그룹단어체커 {
    public static int check(String str){
        int count=1;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<str.length()-1;i++){
            char ch=str.charAt(i);
            char next_ch=str.charAt(i+1);
            set.add(ch);
            if(ch==next_ch){
                continue;
            }else{
                if(set.contains(next_ch)){
                    count=0;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        int sum=0;
        for(int i=0;i<n;i++){
            String str=input.readLine();
            sum+=check(str);
        }
        System.out.println(sum);
    }
}
