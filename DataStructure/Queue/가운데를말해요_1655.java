package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
7
1
5
2
10
-99
7
5
 */

/**
 * 실시간 입력된 데이터를 정렬하는 자료구조 = Heap
 * - 이 문제의 핵심 실시간으로 데이터를 입력받으면서 가운데 값을 바로 아는 방법에는 무엇이 있을까??
 * - 2개의 우선순위큐를 이용해서 최대힙과 최소힙을 이용해서 size 오차 범위를 1로해서 데이터를 넣으면
 *   실시간으로 기억 할 수 있다.
 */
public class 가운데를말해요_1655 {

    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            sb.append(getMidValue(Integer.parseInt(input.readLine()))).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 새로운 데이터가 들어 갈 때
     * 1. maxHeap의 제일 큰 데이터보다 minHeap의 제일 작은 데이터와 비교
     * 2. maxHeap의 데이터 보다 크다면 minHeap에 삽입.
     * 3. maxHeap의 데이터보다 작다면 maxHeap에 삽입.
     * 4. 크기를 비교하고 둘의 오차를 1로 조정
     * @param val
     * @return
     */
    private static int getMidValue(int val) {

        if(maxHeap.size() == 0){
            maxHeap.add(val);
            return val;
        }

//        if(minHeap.size() == 0){
//            if(maxHeap.peek() > val){
//                int value = maxHeap.poll();
//                minHeap.add(value);
//                maxHeap.add(val);
//            }else{
//                minHeap.add(val);
//            }
//            return Math.min(maxHeap.peek(), minHeap.peek());
//        }


        if(maxHeap.peek() > val){
            maxHeap.add(val);
        }else{
            minHeap.add(val);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            int value = maxHeap.poll();
            minHeap.add(value);
        }

        if(minHeap.size() > maxHeap.size() + 1){
            int value = minHeap.poll();
            maxHeap.add(value);
        }

        if(maxHeap.size() == minHeap.size()){
            return Math.min(maxHeap.peek(), minHeap.peek());
        }else{
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}
