package DataStructure.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo= {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();

        for ( int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for( int i = 0; i < photo.length; i++) {
            int sum = 0;
            for ( int j = 0; j < photo[i].length; j++) {
                String photoName = photo[i][j];
                sum += map.getOrDefault(photoName,0);
            }
            answer[i] = sum;
        }

        System.out.println(answer);

    }
}
