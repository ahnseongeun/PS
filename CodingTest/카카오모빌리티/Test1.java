package CodingTest.카카오모빌리티;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws Exception{
        String S = "2234567";
        String result = S.replaceAll("-","").replaceAll(" ","");
        boolean check = result.length() % 3 == 1;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < result.length(); i++){
            if(check && i >= result.length() - 2){
                sb.append(result.charAt(i));
                continue;
            }
            if(cnt == 3) {
                cnt = 0;
                sb.append("-");
                i--;
            }else{
                cnt++;
                sb.append(result.charAt(i));
            }
        }
        if(check) sb.insert(sb.length() - 2,"-");

        System.out.println(sb);
    }
}
