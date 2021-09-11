package CodingTest.라인2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {

        int[] student = { 0, 1, 0, 0, 1, 1, 0 };
        int k = 2;

        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < student.length; i ++) {
           if(student[i] == 1) list.add(i);
        }

        for(int i = 0; i <= list.size() - k; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < k; j++) {
                temp.add(list.get(i + j));
            }
            int[] result = Arrays.stream(temp.toArray()).mapToInt(value -> (int) value).toArray();
        }
    }
}
