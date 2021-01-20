package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 단어공부_1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine().toUpperCase();
        HashMap<Character, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            wordCount.put(ch, wordCount.getOrDefault(ch,1)+1);
        }

        int max = 0;
        char result = '?';
        for(char tmp:wordCount.keySet()){
            if(wordCount.get(tmp)>max){
                max = wordCount.get(tmp);
                result = tmp;
            }else if(wordCount.get(tmp)==max){
                result = '?';
            }else{
                continue;
            }
        }

        System.out.println(result);
    }
}
