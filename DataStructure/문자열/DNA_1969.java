package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 8
TATGATAC
TAAGCTAC
AAAGATCC
TGAGATAC
TAAGATGT

TAAGATAC
7
 */
public class DNA_1969 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] strings = new String[n];
        for(int i = 0; i < n; i++) strings[i] = input.readLine();

        int[] chars = new int[26];
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            Arrays.fill(chars, 0);
            for(int j = 0; j < n; j++) {
                char ch = strings[j].charAt(i);
                chars[ch - 'A']++;
            }

            int max = -1;
            char ch = 'A';
            for(int j = 0; j < 26; j++) {
                if(max < chars[j]) {
                    max = chars[j];
                    ch = (char)(j + 'A');
                }
            }
            sb.append(ch);
            for(int j = 0; j < n; j++) {
                if(ch == strings[j].charAt(i)) continue;
                cnt++;
            }
        }

        System.out.println(sb);
        System.out.println(cnt);
    }
}
