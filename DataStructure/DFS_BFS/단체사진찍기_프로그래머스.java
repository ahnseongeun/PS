package DataStructure.DFS_BFS;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 단체사진찍기_프로그래머스 {

    private static char result[];
    private static boolean visited[];
    private static int count = 0;

    private static void dfs(int idx, char arr[],String[] data){
        if(idx == 8){
            for(int i = 0; i < data.length; i++){
                String command = data[i];
                char start = command.charAt(0);
                char end = command.charAt(2);
                int start_idx = 0;
                int end_idx = 0;
                for(int j = 0; j < 8; j++){
                    if(start == result[j])
                        start_idx = j;
                    if(end == result[j])
                        end_idx = j;
                }
                char oper = command.charAt(3);
                int num = command.charAt(4) - '0';
                if(oper == '<'){
                    if(Math.abs(start_idx - end_idx) - 1 >= num)
                        return;
                }else if(oper == '='){
                    if(Math.abs(start_idx - end_idx) - 1 != num)
                        return;
                }else{
                    if(Math.abs(start_idx - end_idx) - 1 <= num)
                        return;

                }
            }
            count++;
            return;
        }

        for(int i = 0; i < 8; i++){
            if(visited[i])
                continue;
            result[idx] = arr[i];
            visited[i] = true;
            dfs(idx + 1, arr, data);
            visited[i] = false;
        }
    }

    public static void main(String[] args){

        char arr[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        String data[] = {"N~F=0", "R~T>2"};
        result = new char[8];
        visited = new boolean[8];
        dfs(0,arr,data);
        System.out.println(count);
    }
}
