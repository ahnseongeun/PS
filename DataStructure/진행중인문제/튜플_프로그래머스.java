package DataStructure.진행중인문제;

import java.util.HashMap;
import java.util.*;

/**
 * 나의 풀이 방식
 * cnt를 기준으로 {}를 하나의 원소로 HashMap에 저장한다.
 * cnt를 순서대로 HashMap에서 꺼내서 문자를 숫자로 바꾸고 해당 숫자가 사용되지 않았으면 answer[cnt]에 값을 넣는다.
 */
class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        HashMap<Integer,String> map = new HashMap<>();
        int cnt = 0;
        boolean flag = false;
        int start_idx = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                flag = true;
                start_idx = i;
            }else if(ch == '}'){
                flag = false;
                map.put(cnt,s.substring(start_idx,i + 1));
                cnt = 0;
            }else if(ch == ','){
                if(flag)
                    cnt++;
            }else{
                continue;
            }
        }
        int answer[] = new int[map.size()];
        boolean visited[] = new boolean[1000001];
        for(int i = 0; i < map.size(); i++){
            String str = map.get(i);
            str = str.substring(1,str.length() - 1);
            StringTokenizer st = new StringTokenizer(str,",");
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(!visited[num]){
                    answer[i] = num;
                    visited[num] = true;
                }
            }
        }



        return answer;
    }
}
