package DataStructure.programmers;

import java.util.HashMap;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        int result = 0;
        for ( int i = 1; i <= s.length() / 2; i++) {
            result = Math.min(result, runEncoding(s, i));
        }
        System.out.println(result);
    }

    private static int runEncoding(String str, int unit) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = str.length();
        for (int i = 0; i < str.length(); i += unit) {
            if (i + unit > str.length()) break;
            String subString = str.substring(i, i + unit);
            System.out.println(subString);
            if ( map.get(subString) != null) {
                if ( map.get(subString) > 1) {
                    result -= unit;
                } else {
                    result -= unit + 1;
                    map.put(subString, 2);
                }
            } else {
                map = new HashMap<>();
                map.put(subString, 1);
            }
        }
        System.out.println(result);
        return result;
    }
}
