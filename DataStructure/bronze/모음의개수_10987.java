package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class 모음의개수_10987 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        String str = input.readLine();
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) if(set.contains(str.charAt(i))) cnt++;
        System.out.println(cnt);
    }
}
