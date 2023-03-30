package DataStructure.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의전당1 {
    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] result = new int[score.length];
        for ( int i = 0; i < score.length; i++) {
            q.add(score[i]);
            if ( i >= k) q.poll();
            result[i] = q.peek();
        }

        Arrays.stream(result).forEach(System.out::println);
    }
}
