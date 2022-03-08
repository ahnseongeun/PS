package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬만들기_1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String error = "I'm Sorry Hansoo";
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch - 'A']++;
        }
        int oddIndex = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            int characterCount = count[i];
            if (characterCount == 0) continue;
            if (characterCount % 2 == 1) {
                if (oddIndex != -1) {
                    System.out.println(error);
                    return;
                }
                oddIndex = i;
            }
            for(int j = 0; j < characterCount / 2; j++) {
                sb.append((char)('A' + i));
            }
        }
        String start = sb.toString();
        if(oddIndex != -1) start += (char)('A' + oddIndex);
        String reverseString = sb.reverse().toString();
        System.out.println(start + reverseString);
    }
}
