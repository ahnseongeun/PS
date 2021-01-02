package 이것이코딩테스트다_BOOK.그리디;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이될때까지{
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int target=n;
        int cnt=0;
        while(true){
            if(target==1)
                break;
            cnt++;
            if(target%m==0){
                target/=m;
            }else{
                target-=1;
            }
        }
        System.out.println(cnt);
    }
}
