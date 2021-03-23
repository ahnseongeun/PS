package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 풀이 접근법
 * 생각할 부분
 * 1. 그래프냐 트리냐 -> 순환관계가 없기 때문에 트리 구조
 * 2. 단독 스킬을 시작점으로 트리 구조를 만든다.
 * 3. 탐색과정인 DFS와 BFS는 상관이 없지만 이런 경우 지나온 정점을 기억해야되서 DFS를 더 좋다.
 *
 * 구현 순서
 * 1. 입력받은 문자열을 저장할 배열
 * 2. 문자열 안의 문자들의 관계를 나타내기 위한 2차원 배열
 * 3. BFS냐 DFS냐
 */
/*
h g f w r
4
h g
h f
g r
g w
 */
public class retest1 {

    private static boolean visited[];
    private static int skillGraph[][];
    private static int startPoint[];
    private static HashMap<Integer,Character> intToSkills;

    private static void dfs(int start,String str) {

        int cnt = 0;
        for(int i = 0; i < skillGraph.length; i++){
            if(skillGraph[start][i] == 1){
                dfs(i,str + intToSkills.get(i) + " ");
                cnt = 0;
            }
            cnt++;
        }
        if(cnt == 5){
            System.out.println(str);
            return;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int skillCount = st.countTokens();

        HashMap<Character,Integer> skillsToInt = new HashMap<>();
        intToSkills = new HashMap<>();
        for(int i = 0; i < skillCount; i++){
            char ch = st.nextToken().charAt(0);
            skillsToInt.put(ch,i);
            intToSkills.put(i,ch);
        }

        skillGraph = new int[skillCount][skillCount];
        startPoint = new int[skillCount];

        int skillLinkCount = Integer.parseInt(input.readLine());
        for(int i = 0; i < skillLinkCount; i++){
            st = new StringTokenizer(input.readLine());
            int start = skillsToInt.get(st.nextToken().charAt(0));
            int end = skillsToInt.get(st.nextToken().charAt(0));
            skillGraph[start][end] = 1;
            startPoint[end] = 1;
        }
        //시작 위치 노드 구하기
        for(int start: startPoint){
            if(start == 1)
                continue;
            String str = intToSkills.get(start) + " ";
            dfs(start,str);
        }


    }
}
