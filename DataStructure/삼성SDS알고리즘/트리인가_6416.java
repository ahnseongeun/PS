package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0
-1 -1
 */
public class 트리인가_6416 {


    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;
        while(true) {

            Set<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            boolean check = false;
            while(true) {
                if(check) break;
                StringTokenizer st = new StringTokenizer(input.readLine());
                while(st.hasMoreTokens()) {
                    int value1 = Integer.parseInt(st.nextToken());
                    int value2 = Integer.parseInt(st.nextToken());
                    if (value1 == 0 && value2 == 0) check = true;
                    if (value1 < 0 && value2 < 0) return;
                    set.add(value1);
                    set.add(value2);
                    //자손 노드 count + 1
                    map.put(value1, map.getOrDefault(value1, 0));
                    map.put(value2, map.getOrDefault(value2, 0) + 1);
                    count++;
                }

            }

            boolean treeCheck = false;
            int rootCount = 0;

            for( int index : set) {
                if(map.get(index) == 0) {
                    rootCount++;
                    if(rootCount > 1) {
                        treeCheck = true;
                        break;
                    }
                }
                if(map.get(index) >= 2) {
                    treeCheck = true;
                    break;
                }
            }

            if(set.size() - 1 != count) treeCheck = true;
            if(!treeCheck || set.size() == 0) {
                System.out.println("Case "+ cnt + " is a tree.");
            } else {
                System.out.println("Case "+ cnt + " is not a tree.");
            }
            cnt++;
        }
    }
}
