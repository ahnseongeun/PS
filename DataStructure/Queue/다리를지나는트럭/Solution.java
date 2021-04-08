package DataStructure.Queue.다리를지나는트럭;

import java.util.*;

/**
 * 일단 q.isEmpty가 아니라 true로 먼저 값을 넣고 마지막에 q.size == 0으로 검사한다.
 */
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckCount = truck_weights.length;

        Queue<int[]> q = new LinkedList<>();
        int idx = 0;
        int wei = 0;

        while(true){
            answer ++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                if (bridge_length - 1 == tmp[1]) {
                    wei -= tmp[0];
                } else {
                    q.add(new int[]{tmp[0], tmp[1] + 1});
                }
            }
            if(idx < truckCount && wei + truck_weights[idx] <= weight) {
                wei += truck_weights[idx];
                q.add(new int[]{truck_weights[idx++], 0});
            }
            if(q.size() == 0)
                break;
            System.out.println(answer);
            q.forEach(ints -> System.out.println(ints[0] +" " + ints[1]));
        }

        return answer;
    }
}