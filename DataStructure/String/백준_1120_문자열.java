package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 백준_1120_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        String str1=st.nextToken();
        String str2=st.nextToken();
        int size= str2.length()-str1.length();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=size;i++){
            int count=0;
            for(int j=i,k=0;j<i+str1.length();j++,k++){
                if(str1.charAt(k)!=str2.charAt(j))
                    count++;
            }
            //최소값 비교
            min=Math.min(count,min);
        }
        System.out.println(min);

    }
}
