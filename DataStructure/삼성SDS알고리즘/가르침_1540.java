package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
3 6
antarctica
antahellotica
antacartica
 */

/**
 * a, n, t, i, c 이렇게 5개를 제외하고 모든 알파벳의 경우를 고려해서 탐색하는방식
 */
public class 가르침_1540 {

    private static boolean[] check;
    private static int result = 0;
    private static ArrayList<String> list;

    private static void dfs(int index, int count, int maxWord) {

        //검사
        if(count == maxWord) {

            int num = 0;
            for(String str : list) {
                int cnt = 0;
                for(int i = 0; i < str.length(); i++) {
                    if(!check[str.charAt(i) - 'a']) break;
                    cnt ++;
                }
                if(cnt == str.length()) num++;
            }
            result = Math.max(result, num);
            return;
        }

        for( int i = index; i < 26; i++) {
            if(check[i]) continue;
            check[i] = true;
            dfs(i, count + 1, maxWord);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        check = new boolean[26];
        checkInit(check);
        int n = Integer.parseInt(st.nextToken());
        int maxWord = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for( int i = 0; i < n; i++) {
            String str = input.readLine();
            str = str.substring(4,str.length() - 4);
            list.add(str);
        }
        if( maxWord == 26) result = n;
        else if( maxWord >= 5) dfs(0, 0, maxWord - 5);

        System.out.println(result);

    }

    private static void checkInit(boolean[] check) {
        check['a'-'a'] = true; //a
        check['c'-'a'] = true; //c
        check['i'-'a'] = true; //i
        check['n'-'a'] = true; //n
        check['t'-'a'] = true; //t
    }
}
