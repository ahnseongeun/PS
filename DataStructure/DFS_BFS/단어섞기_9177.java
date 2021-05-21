package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
qq ee qqer
 */
/*
7
cat tree tcraete
cat tree catrtee
cat tree cttaree
cc cc cccc
ac ca acca
ac cb acbc
qq ee qqez -> 이렇게 되면 r 까지 가게되는 불필요한 계산을 하게되는 것이다.
//처음에 불필요한 단어가 들어가 있는지 체크해주자
 */
public class 단어섞기_9177 {

    private static String str1;
    private static String str2;
    private static String target;
    private static boolean flag;

    private static boolean wordCheck() {

        for(int i = 0; i < target.length(); i++){
            char ch = target.charAt(i);
            if(str1.indexOf(ch) == -1 && str2.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    private static void check(int idx1, int idx2, int idx3) {

        if(flag)
            return;

        if(idx1 == str1.length() && idx2 == str2.length() ) {
            flag = true;
            return;
        }

        if(idx1 < str1.length() && str1.charAt(idx1) == target.charAt(idx3)){
            check(idx1 + 1, idx2 , idx3 + 1);
        }

        if(idx2 < str2.length() && str2.charAt(idx2) == target.charAt(idx3)){
            check(idx1 , idx2 + 1, idx3 + 1);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            str1 = st.nextToken();
            str2 = st.nextToken();
            target = st.nextToken();
            flag = false;
            if(wordCheck())
                check(0,0,0);
            sb.append("Data set ").append(i + 1).append(": ").append(flag ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
