package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1,2,3,4,5,6,7
public class 요세푸스문제3_11025 {
    public static void main(String[] args) throws  Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        boolean check[]=new boolean[n];
        check[0]=true;
        int start=k;
        int cnt=0;
        while(true){
            check[start]=true;
            System.out.println(start);
            cnt++;
            if(cnt==check.length-1)
                break;
            start=(start+k)%(check.length);
        }
        for(boolean bool:check)
            System.out.println(bool);
    }
}
