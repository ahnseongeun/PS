package DataStructure.programmers;

import java.util.Arrays;

public class 바탕화면정리 {
    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};
        int rowLen = wallpaper.length;
        int colLen = wallpaper[0].length();
        int startX = 50;
        int startY = 50;
        int endX = 0;
        int endY = 0;
        for ( int i = 0; i < rowLen; i++) {
            for ( int j = 0; j < colLen; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    startX = Math.min(j, startX);
                    startY = Math.min(i, startY);
                    endX   = Math.max(j, endX);
                    endY   = Math.max(i, endY);
                }
             }
        }
        int[] answer = new int[]{startX, startY, endX, endY};
        System.out.println(Arrays.toString(answer));
    }
}