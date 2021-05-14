package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
(0/(0))
 */
public class 괄호제거_2800 {

    private static String str;
    private static boolean visited[];
    private static StringBuilder result = new StringBuilder();;

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine();
        visited = new boolean[str.length()];
        erase(0,0);
        System.out.println(result);
    }

    private static void erase(int idx, int pair) {
        //idx가 str.length()와 같다면 return
        if(idx == str.length()){
            if(pair == 0){

            }
            return;
        }

        if(str.charAt(idx) == '('){
            erase(idx + 1, pair);
            visited[idx] = true;
            erase(idx + 1, pair + 1);
        }else if(str.charAt(idx) == ')'){
            erase(idx + 1, pair);
            visited[idx] = true;
            erase(idx + 1, pair - 1);
        }else{
            erase(idx + 1, pair);
        }

    }
}
