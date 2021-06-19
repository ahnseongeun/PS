package CodingTest.삼성SDS입과테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
159 555 2
+-
1142 350 3
+0-
116 676 2
+-
887 854 2
0-
370 994 2
+0
1
000 111 1
+++
 */

/**
 * 주어진 수로 변경할 수 없다면 -1
 * 최소 필터 사용
 */
public class Test2 {

    private static boolean visited[] = new boolean[1000000];
    private static int getMin(int start, int target, String[] filters) {

        Arrays.fill(visited,false);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        visited[start] = true;
        int result = 1000000000;

        while(!q.isEmpty()){

            int[] temp = q.poll();
            int number = temp[0];
            int cnt = temp[1];

            //System.out.println(number + " " + cnt);
            if(number == target)
                result = Math.min(result,cnt);

            String str = String.valueOf(number);

            for(int i = 0; i < 2; i++){
                String filter = filters[i];
                int len = str.length();
                for(int j = 0; j < len - filter.length() + 1; j++){
                    char[] chs = str.toCharArray();
                    boolean flag = false;

                    for(int k = 0; k < filter.length(); k++){
                        if(filter.charAt(k) == '+'){
                            if(chs[k + j] == '9') {
                                flag = true;
                                break;
                            } else {
                                chs[k + j] = (char)(chs[k + j] + 1);
                            }

                        }
                        if(filter.charAt(k) == '-'){
                            if(chs[k + j] == '0') {
                                flag = true;
                                break;
                            } else {
                                chs[k + j] = (char)(chs[k + j] - 1);
                            }
                        }
                    }

                    if(flag) continue;
                    else {
                        int num = 0;
                        for(int k = 0; k < chs.length; k++){
                            num *= 10;
                            num += (chs[k] - '0');
                        }

                        if(!visited[num]) {
                            visited[num] = true;
                            q.add(new int[]{num, cnt + 1});
                        }
                    }
                }
            }

        }

        return result == 1000000000 ? -1 : result;
    }

    private static char[] reverse(char[] filter) {
        for(int i = 0; i < filter.length / 2; i++){
            char temp = filter[i];
            filter[i] = filter[filter.length - i - 1];
            filter[filter.length - i - 1] = temp;
        }
        return filter;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int filter_size = Integer.parseInt(st.nextToken());
            String[] filters = new String[2];
            filters[0]= input.readLine();
            filters[1] = new StringBuilder(filters[0]).reverse().toString();

            sb.append("#").append(i + 1).append(" ")
                    .append(getMin(start, target,filters)).append("\n");
        }
        System.out.println(sb);
    }
}
