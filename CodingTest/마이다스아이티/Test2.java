package CodingTest.마이다스아이티;

import JAVA.문자열_TO_INT;

import java.io.BufferedReader;
import java.util.*;

/*
HashMap을 쓰고(Integer, Set) 팀, 학생 번호들
학생 번호(Integer, int[]) 팀, 점수
 */
public class Test2 {

    public static int solution(int n, int[] v1, int[] v2, int[] num, int[] amount) {
        int answer = 0;

        int[] scores = new int[n + 1];
        //팀, 학생 번호들
        HashMap<Integer, Set<Integer>> map1 = new HashMap<>();
        //학생 번호 (팀, 점수)
        HashMap<Integer, Integer> map2 = new HashMap<>();
        boolean[] check = new boolean[n + 1];
        int size = 0;

        for(int i = 0; i < v1.length; i++){

            int idx1 = Math.min(v1[i],v2[i]);
            int idx2 = Math.max(v1[i],v2[i]);
            check[idx1] = true;
            check[idx2] = true;
            //둘다 진행
            if(map2.get(idx1) == null && map2.get(idx2) == null){
                size = map1.size() + 1;
                Set<Integer> set = new HashSet<>();
                set.add(idx1);
                set.add(idx2);
                map1.put(size,set);
                map2.put(idx1,size);
                map2.put(idx2,size);
            //team2에 대해서 진행
            }else if(map2.get(idx1) == null){
                int teamIdx = map2.get(idx2);
                Set<Integer> set = map1.get(teamIdx);
                set.add(idx1);
                map1.put(teamIdx,set);
                map2.put(idx1,teamIdx);
            //team1에 대해서 진행
            }else if(map2.get(idx2) == null){
                int teamIdx = map2.get(idx1);
                Set<Integer> set = map1.get(teamIdx);
                set.add(idx2);
                map1.put(teamIdx,set);
                map2.put(idx2,teamIdx);
           } else {
                int teamIdx_temp = map2.get(idx2);
                Set<Integer> set_temp = map1.get(teamIdx_temp);
                int teamIdx = map2.get(idx1);
                Set<Integer> set = map1.get(teamIdx);
                for(int idx : set_temp) map2.put(idx,teamIdx);
                set.addAll(set_temp);
                map1.put(teamIdx_temp,new HashSet<>());
                map1.put(teamIdx,set);
            }
        }


        for(int i = 1; i <= n; i++){
            if(check[i]) continue;
            size++;
            Set<Integer> set = new HashSet<>();
            set.add(i);
            map1.put(size,set);
            map2.put(i,size);
        }

        System.out.println(map1);
        for(int i = 0; i < num.length; i++){
            int idx = num[i];
            int score = amount[i];
            int temp = map2.get(idx);
            scores[temp] += score;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= size; i++){
            if(scores[i] > max){
                max = scores[i];
                result.clear();
                result.add(i);
            } else if(scores[i] == max) {
                result.add(i);
            }
        }

        int minIdx = 100000000;
        for(int i = 0; i < result.size(); i++){
            int teamIdx = result.get(i);
            for(int idx : map1.get(teamIdx)) minIdx = Math.min(minIdx,idx);
        }
        return minIdx;
    }

    public static void main(String[] args) throws Exception{

        int n = 6;
        int[] v1 = {};
        int[] v2 = {};
        int[] num = {1, 2, 3};
        int[] amount = {2,2,2};
        System.out.println(solution(n, v1, v2, num, amount));
    }
}
