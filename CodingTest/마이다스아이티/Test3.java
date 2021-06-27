package CodingTest.마이다스아이티;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test3 {

    //HashMap<몇일, Set<index>>
    public static int solution(int n,int k, int [][]t) {
        int answer = 0;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] count = new int[n + 1]; //총 몇일의 기간이 있는지
        boolean[] check = new boolean[n + 1]; // 확인 했는지

        for(int i = 0; i < n; i++){
            int start = t[i][0];
            int end = t[i][1] ;
            for(int j = start; j <= end; j++) {
                Set<Integer> set;
                if(map.get(j) == null) {
                    set = new HashSet<>();
                } else {
                    set = map.get(j);
                }
                set.add(i + 1);
                map.put(j, set);
            }
            count[i + 1] = end - start + 1;
        }


        for(int i = 1; i <= k; i++){
            Set<Integer> set = map.get(i);
            int minIdx = 0;
            int min = Integer.MAX_VALUE;
            for(int idx : set){
                if(check[idx]) continue;
                if(i < k && !map.get(i + 1).contains(idx)){
                    min = count[idx];
                    minIdx = idx;
                    break;
                }
                if(count[idx] < min ){
                    min = count[idx];
                    minIdx = idx;
                }
            }
            if(min == Integer.MAX_VALUE) continue;
            check[minIdx] = true;
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception{
        int n = 4;
        int k = 4;
        //int[][] t = {{1,4}};
        int[][] t = {{3,1},{1,1},{2,3},{3,4}};
        int num = solution(n, k, t);
        System.out.println(num);
    }
}
