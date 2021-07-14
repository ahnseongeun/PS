package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
cat tree tcraete
cat tree catrtee
cat tree cttaree
 */
public class 단어섞기_9177 {

    private static String getMakeString(String str1, String str2, String result) {

        int index1 = 0;
        int index2 = 0;
        return "";
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String result = st.nextToken();
            sb.append("Data set 1: ").append(getMakeString(str1, str2, result));
        }
        System.out.println(sb);
    }
}
