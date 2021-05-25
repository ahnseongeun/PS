package DataStructure.구현;


import java.util.LinkedList;

import java.util.*;
/**
 1. 캐시 크기는 최대 30
 2. 최대 도시수는 100000, 도시 이름은 최대 20자
 */
class Solution {

    private static int getExecuteTime(int cacheSize, String[] cities){

        Queue<String> q = new LinkedList<>();

        int time = 0;
        if(cacheSize == 0)
            return cities.length * 5;
        for(int i = 0; i < cities.length ; i++){
            String city = cities[i].toLowerCase();

            if(q.contains(city)){
                q.remove(city);
                q.add(city);
                time += 1;
            }else{

                if(q.size() < cacheSize){
                    q.add(city);
                }else{
                    q.poll();
                    q.add(city);
                }
                time += 5;
            }
        }
        return time;
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = getExecuteTime(cacheSize,cities);
        return answer;
    }
}

public class 캐시_프로그래머스 {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.solution(0,new String[5]));
    }
}
