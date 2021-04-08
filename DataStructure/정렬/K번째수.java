package DataStructure.정렬;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int size = commands.length;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            int[] command = commands[i];
            int[] tmp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tmp);
            answer[i] = tmp[command[2] - 1];
        }
        System.out.println(answer);
    }
}
