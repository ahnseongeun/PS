package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 편집거리_DP {
    private static void display(int[][] dp,int strSize,int targetSize) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=strSize;i++){
            for(int j=1;j<=targetSize;j++){
                sb.append(dp[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str1= input.readLine();
        String str2= input.readLine();
        int strSize=0;
        int targetSize=0;
        char str[];
        char target[];
        if(str1.length()>str2.length()){
            str=str2.toCharArray();
            target=str1.toCharArray();
        }else{
            str=str1.toCharArray();
            target=str2.toCharArray();
        }
        strSize=str.length;
        targetSize=target.length;
        int dp[][]=new int[strSize+1][targetSize+1];
        boolean flag=false;
        for(int i=1;i<=strSize;i++){
            flag=false;
            for(int j=i;j<=targetSize;j++){
                if(i==1){
                    if(str[i-1]!=target[j-1]){
                        dp[i][j]=dp[i][j-1]+1;
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }else{
                    if(str[i-1]!=target[j-1]&&!flag){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j]-1;
                        flag=true;
                    }
                }
            }
        }
        display(dp,strSize,targetSize);
        System.out.println(dp[strSize][targetSize]);
    }
}
