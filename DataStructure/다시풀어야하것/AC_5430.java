package DataStructure.다시풀어야하것;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
 */
public class AC_5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = input.readLine();
            int m = Integer.parseInt(input.readLine());
            Deque<Integer> arr = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(input.readLine()
                    .replace("[","")
                    .replace("]",""),",");
            for(int j = 0; j < m; j++) arr.add(Integer.parseInt(st.nextToken()));
            boolean flag = false;
            boolean direction = true; // true 정, false 부
            if(arr.isEmpty()) flag = true;
            for(int j = 0; j < str.length(); j++) {
                char command = str.charAt(j);
                if(command == 'R') {
                    direction = !direction;
                }
                if(command == 'D') {
                    if(arr.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if(direction) arr.pollFirst();
                    else arr.pollLast();
                }
            }

            if(flag) {
                sb.append("error");
            }
            else {
                sb.append("[");
                for(int j = 0; j < arr.size(); i++) {
                    if(j == arr.size() - 1) {
                        sb.append(arr.pollLast());
                        break;
                    }
                    //정방향
                    if(direction) {
                        sb.append(arr.pollFirst()).append(",");
                    } else {
                        sb.append(arr.pollLast()).append(",");
                    }
                }
                sb.append("]");
            }
            System.out.println(sb);
        }
    }
}
