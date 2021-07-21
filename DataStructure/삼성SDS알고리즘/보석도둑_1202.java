package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 가방을 오름차순으로 정렬
 * 2. 주얼리를 무게순으로 정렬
 * 3. 해당 가방 무게만큼 주얼리를 값어치 순으로 정렬하는 PQ에 삽입
 * 4. pq.poll()을 하면 해당 가방 무게에서 가능한 가장 높은 값어치의 보석 반환 
 */
public class 보석도둑_1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long result = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewelry = new int[n][2];
        int[] bag = new int[k];

        for( int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken()); //무게
            jewelry[i][1] = Integer.parseInt(st.nextToken()); //값
        }

        for( int i = 0; i < k; i++) bag[i] = Integer.parseInt(input.readLine());


        // 1. 가방 오름 차순 정렬
        Arrays.sort(bag);
        // 2. 보석 무게순 오름차순 정렬
        Arrays.sort(jewelry, (o1, o2) -> o1[0] - o2[0]);

        // 3. 보석 높은값 기준 힙
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        // 제일 작은 가방 선택
        // 남은 보석중에 가장 비싼 보석 선택
        int index = 0;
        for(int i = 0; i < bag.length; i++) {

            //현재 가방에 알맞은 무게 전부다 넣기
            for(int j = index; j < jewelry.length; j++) {
                if(bag[i] < jewelry[j][0]) break;
                index++;
                pq.add(new int[]{jewelry[j][0],jewelry[j][1]});
            }

            //pq는 값어치 순으로 정렬되었기 때문에 pq.poll 진행
            if(pq.isEmpty()) continue;
            result += pq.poll()[1];
        }

        System.out.println(result);
    }
}
