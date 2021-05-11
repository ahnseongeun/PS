package DataStructure.다시풀어야하것;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
()(())))
 */
public class 오타_5875_재귀시간초과 {

    private static int cnt = 0;
    private static char[] str;

    private static void getError(int idx,int sum,int count) {
        if(idx == str.length) {
            if (sum == 0) {
                cnt++;
            }
            return;
        }
        if(sum < 0 || count > 1)
            return;
        char ch = str[idx];
        if(ch == '('){
            getError(idx + 1, sum + 1,count);
            getError(idx + 1, sum - 1,count + 1);

        }else{
            getError(idx + 1, sum - 1,count);
            getError(idx + 1, sum + 1,count + 1);

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine().toCharArray();
        getError(0,0,0);
        System.out.println(cnt);
    }
}
