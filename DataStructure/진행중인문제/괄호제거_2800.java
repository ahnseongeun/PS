package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
(0/(0))
-------
(0/0)
0/(0)
0/0
 */

/**
 * 정답 중복제거
 */
public class 괄호제거_2800 {

    private static String str;
    private static ArrayList<int[]> pair;
    private static boolean visited[];
    private static boolean check[];
    private static Set<String> result;

    private static void getPair() {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(') stack.add(i);
            if(ch == ')') pair.add(new int[]{stack.pop(),i});
        }
    }

    private static void erase(int idx) {

        if(idx == pair.size()){
            Arrays.fill(check,false);
            boolean flag = false;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    int[] tmp = pair.get(i);
                    check[tmp[0]] = true;
                    check[tmp[1]] = true;
                    flag = true;
                }
            }

            if(!flag)
                return;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < check.length; i++)
                if(!check[i]) sb.append(str.charAt(i));
            result.add(sb.toString());
            return;
        }

        visited[idx] = true;
        erase(idx + 1);
        visited[idx] = false;
        erase(idx + 1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine();
        pair = new ArrayList<>();
        getPair();
        visited = new boolean[pair.size()];
        check = new boolean[str.length()];
        result = new TreeSet<>();
        erase(0);
        StringBuilder sb = new StringBuilder();
        for(String str : result)
            sb.append(str).append("\n");
        System.out.println(sb);
    }
    
}
