package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1,2,3,4,5,6,7
//false는 사이에 2개가 있어야하고 마지막이 false가 아니라면 재탐색?
public class 요세푸스문제3_11025 {
    public static void main(String[] args) throws  Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        boolean check[]=new boolean[n];
        ArrayList<Integer> list=new ArrayList<>();
//        int start=0;
//        for(int i=1;i<=n;i++) {
//            start = (start + k) % i;
//        }
//        System.out.println(start+1);

        int cnt=0;
        int count=0;
        int start=k-1;
        while(cnt!=n-1){
            check[start]=true;
            //sb.append(start+1+" ");
            list.add(start+1);
            while(count!=k-1){
                start%=n;
                if(check[start++])
                    continue;
                count++;
            }
            while(true){
                start%=n;
                if(check[start]){
                    start++;
                    start%=n;
                }else{
                    break;
                }
            }
            count=0;
            cnt++;
        }
        System.out.println(list.toArray());
    }
}
