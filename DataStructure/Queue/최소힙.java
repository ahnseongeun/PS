package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int n = Integer.parseInt(input.readLine());
        for(int i = 0;i < n; i++){
            int num = Integer.parseInt(input.readLine());
            if(num == 0){
                if(pq.isEmpty())
                    sb.append(0+"\n");
                else
                    sb.append(pq.remove()).append("\n");
            }else{
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
