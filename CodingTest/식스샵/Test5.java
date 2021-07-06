package CodingTest.식스샵;

import java.util.PriorityQueue;

public class Test5 {


    public static void main(String[] args) throws Exception{
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{1});
        pq.add(new int[]{2});
        pq.add(new int[]{3});
        pq.add(new int[]{4});
        pq.add(new int[]{5});
        for(int[] val : pq) val[0] += 2;
        for(int[] val : pq) System.out.println(val[0]);
    }
}
