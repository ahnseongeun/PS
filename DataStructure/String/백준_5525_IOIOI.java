package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//일반적으로 문자열 검색을 이용하면 서브 문자열을 index를 증가시키면서 검사하는 방법 O(NM)방법을 떠올리지만
//KMP 문자열 검색을 이용하면 O(N+M을)이용해서 검색할수 있다.
//KMP 연관관계 문자열 5525, 10769, 1786번 문제
public class 백준_5525_IOIOI {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        sb.append("IOI");
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        String str=input.readLine(); //전체 문자열 입력받고

        for(int i=1;i<n;i++)
            sb.append("OI");
        String temp=sb.toString(); //비교 문자열 입력

        int start=0;
        int end=temp.length();
        while(true){
            if(start==end)
                break;
            for(int i=start;i<end;i++){
            }
        }
    }
}
