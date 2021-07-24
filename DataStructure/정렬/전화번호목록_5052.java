package DataStructure.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬을 이용한다면 어떤 특정 문자열에서 다른 모든 문자열을 검사할 필요없다.
 * 단지, 정렬된 문자열들 중에서 이웃된 문자열만 검사하면된다. 둘은 필연적인 관계까 있기 때문이다.
 */
public class 전화번호목록_5052 {

    private static boolean checkPhoneNumber(String[] strs) {
        Arrays.sort(strs);
        for(int i = 1; i < strs.length; i++){
            if(strs[i].startsWith(strs[i - 1])) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(input.readLine());
            String[] strs = new String[m];
            for(int j = 0; j < m; j++) strs[j] = input.readLine();
            if(!checkPhoneNumber(strs)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
