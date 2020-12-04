package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class 백준_14425_문자열집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int count=0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(input.readLine());
        for(int i=0;i<m;i++) {
            if(set.contains(input.readLine()))
                count++;
        }
        System.out.println(count);
    }
}
