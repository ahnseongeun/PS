package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
a b bc bda bca bcda
 */
public class 문자열DP {
    public static void main(String[] args) throws Exception{
        String words[] = {"a","b","ba","bda","bca","bcda"};
        int length = 0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        HashMap<String,Integer> wordByLength = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            wordByLength.put(word,1);
            for(int j = 0;j < word.length(); j++){
                //문자열을 가지고 놀기 위해서는 Buffer를 사용해야 한다.
                StringBuffer compareWord = new StringBuffer();
                compareWord.append(word);
                compareWord.deleteCharAt(j);
                String str = compareWord.toString();
                if(wordByLength.containsKey(str)){
                    wordByLength.put(word,Math.max(wordByLength.get(word),wordByLength.get(str)+1));
                }
            }
            length = Math.max(length, wordByLength.get(word));
            System.out.println(length);
        }
        System.out.println("length: " + length);
    }
}
