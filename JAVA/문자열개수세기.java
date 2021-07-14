package JAVA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 문자열개수세기 {
    public static void main(String[] args) {
        String str1 = "abbbcbbb";
        String str2 = "bbb";

        int[][] arr = new int[3][3];
        System.out.println(arr.length);
        int result = 0;
        int cnt = 1;
        int size = str2.length();
        while(str2.length() + ((str2.length() - 1) * (cnt - 1)) <= str1.length()) {
            for (int i = 0; i < str1.length(); i++) {
                boolean flag = false;
                int index = i;
                int count = 0;
                for (int j = 0; j < str2.length(); j ++) {
                    if (index >= str1.length()) {
                        break;
                    }
                    if (str1.charAt(index) == str2.charAt(j)) {
                        index += cnt;
                        count++;
                        continue;
                    }
                    break;
                }
                if(count != size) flag = true;
                if (flag) continue;
                result++;
            }
            cnt++;
        }
        System.out.println(result);
    }

    private static void makeString(String str2) {
        HashMap<Integer,String> map = new HashMap<>();
        int cnt = 0;
        while(true) {
            StringBuilder sb = new StringBuilder();
            if(sb.length() > 100) break;
            for(int i = 0; i < str2.length(); i++) {
                sb.append(str2.charAt(i));
                if( i == str2.length() - 1) break;
                for(int j = 0; j < cnt; j++) {
                    sb.append("_");
                }
            }
        }
    }
}
