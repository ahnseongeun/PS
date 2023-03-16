package DataStructure.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"GG","AABB"};
        int[] answer = new int[targets.length];
        int[] keyCount = new int[26];
        Arrays.fill(keyCount, 100);
        getMinKeyCount(keymap, keyCount);
        calculateTargetKeyCount(targets, answer, keyCount);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static void calculateTargetKeyCount(String[] targets, int[] answer, int[] keyCount) {
        int cnt = 0;
        for (String target : targets) {
            int sum = 0;
            for (int i = 0; i < target.length(); i++) {
                int index = target.charAt(i) - 'A';
                if ( keyCount[index] == 100) {
                    sum = -1;
                    break;
                }
                sum += keyCount[index];
            }
            answer[cnt] = sum;
            cnt++;
        }
    }

    private static void getMinKeyCount(String[] keymap, int[] keyCount) {
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'A';
                if (i < keyCount[index]) keyCount[index] = i + 1;
            }
        }
    }
}
