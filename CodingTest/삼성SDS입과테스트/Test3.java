package CodingTest.삼성SDS입과테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1
5 4
01000
00110
10001
01001
 */
public class Test3 {

    private static int unLock(int n, int m, int num,int[][] locks) {

        int count = 0;
        for(int i = 0; i < m; i++){
            if(locks[num][i] == '1') continue;
            int diff = 0;
            for(int j = num; j < n; j++){
                diff++;
                if(locks[j][i] == '1') break;
            }
            int diff2 = 0;
            for(int j = num; j >= 0; j--){
                diff2++;
                if(locks[j][i] == '1') break;
            }
            count += Math.min(diff,diff2);
        }
        return count;
    }

    private static int getMin(int n, int m, ArrayList<Integer> list,int[][] lock) {

        int result = 1000001;
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            result = Math.min(result,unLock(n, m, num,lock));
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(input.readLine());

        for(int i = 0; i < total; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] lock = new int[n][m];
            int max = 0;

            //1이 가장 많은 가로 인덱스 저장 용도
            ArrayList<Integer> list = new ArrayList<>();

            for(int j = 0; j < n; j++){
                String str = input.readLine();
                int cnt = 0;
                for(int k = 0; k < m; k++){
                    lock[j][k] = str.charAt(k);
                    if(lock[j][k] == '1') cnt++;
                }
                if(max < cnt){
                    list = new ArrayList<>();
                    list.add(j);
                    max = cnt;
                }else if(max == cnt){
                    list.add(j);
                }
            }

            sb.append("#").append(i + 1).append(" ").append(getMin(n, m, list, lock)).append("\n");
        }
        System.out.println(sb);
    }
}
