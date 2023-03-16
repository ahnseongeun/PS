package DataStructure.programmers;

import java.util.Arrays;

public class 바탕화면정리 {
    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};
        int[] answer = new int[4];
        int colLen = wallpaper[0].length();
        int startX = colLen;
        int startY = colLen;
        int endX = 0;
        int endY = 0;
        for ( int i = 0; i < wallpaper.length; i++) {
            for ( int j = 0; j < colLen; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (j <= startX) startX = j;
                    if (i <= startY) startY = i;
                    if (j >= endX) endX = j + 1;
                    if (i >= endY) endY = i + 1;
                }
             }
        }
        System.out.println(startY + " " + startX + " " + endY + " " + endX);
    }
}