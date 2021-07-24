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
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        int count = 1;
        while(!check) {
            Set<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            boolean check1 = true;
            while(check1) {
                String str = input.readLine();
                for (int i = 0; i < str.length(); i += 5) {
                    int val1 = str.charAt(i) - '0';
                    int val2 = str.charAt(i + 2) - '0';
                    if(set.size() == 0 && val1 == 0 && val2 == 0){
                        check1 = false;
                    }
                    set.add(val1);
                    set.add(val2);
                    map.put(val2, map.getOrDefault(val2,0) + 1);
                    if(val1 == 0 && val2 == 0) {
                        String result = input.readLine();
                        if(result != null && result.length() > 2) check = true;
                        check1 = false;
                        break;
                    }
                }
            }
            boolean result = false;
            for(int idx : set) {
                if(idx == 0) continue;
                if(map.get(idx) == null) continue;
                if( map.get(idx) > 1) {
                    result = true;
                    break;
                }
            }

            if(!result) {
                sb.append("Case ").append(count).append(" is a tree.").append("\n");
            } else {
                sb.append("Case ").append(count).append(" is not a tree.").append("\n");
            }
            count++;
        }
        System.out.println(sb);
    }
}
