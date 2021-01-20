package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬_1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String arr[]=new String[n];
        for(int i = 0;i < n;i++){
            String str = input.readLine();
            arr[i] = str;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()-o2.length()==0)
                    return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        //이전값과 비교하는 방법
        String preString = "";
        for(int i = 0;i < n;i++) {
            if(preString.equals(arr[i]))
                continue;
            preString=arr[i];
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
