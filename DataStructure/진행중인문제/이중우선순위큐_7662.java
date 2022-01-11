package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
 */
public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(input.readLine());
            PriorityQueue<Integer> minPq = new PriorityQueue<>((o1, o2) -> o1 - o2);
            PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int j = 0; j < t; j++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                char ch = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if(ch == 'I') {
                    minPq.add(value);
                    maxPq.add(value);
                }
                else {
                    if(maxPq.isEmpty()) continue;
                    if(value == 1) minPq.remove(maxPq.poll());
                    else maxPq.remove(minPq.poll());
                }
            }
            if(maxPq.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(maxPq.poll()).append(" ").append(minPq.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
