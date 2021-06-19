package CodingTest.사람인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
3
255-128-3
254-128-3
254-128-19
1
0
0
1
3
254-255-255
255-254-255
255-255-254
 */
public class Test2 {

    private static String[] getBitArray(int m, StringTokenizer st) {
        String[] result = new String[m];

        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            result[i] = String.format("%8s", Integer.toBinaryString(number)).replace(" ", "0");
        }

        return result;
    }

    private static int getFindDifferentBit(int m, String[][] degree) {

        int count = 0;
        for(int i = 0; i < m; i++){
            String low = degree[0][i];
            String high = degree[1][i];
            String mid = degree[2][i];
            for(int j = 0; j < 8; j++){
                if(low.charAt(j) != high.charAt(j) || low.charAt(j) != mid.charAt(j) || high.charAt(j) != mid.charAt(j))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(input.readLine());
            String[][] degree = new String[3][m];
            for(int j = 0; j < 3; j++){
                StringTokenizer st = new StringTokenizer(input.readLine(), "-");
                degree[j] = getBitArray(m, st);
            }
            sb.append(getFindDifferentBit(m, degree)).append("\n");
        }
        System.out.println(sb);
    }
}
