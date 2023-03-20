package DataStructure.programmers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 덧칠하기 {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};
        int startIdx = 0;
        int result = 0;
        for ( int i = 1; i <= n; i++) {
            if (startIdx < section.length && section[startIdx] == i) {
                for ( int j = i; j < i + m; j++) {
                    if ( j > n || startIdx >= section.length) break;
                    if ( section[startIdx] == j) {
                        startIdx++;
                    }
                }
                result++;
            }
        }
        System.out.println(result);
    }
}


