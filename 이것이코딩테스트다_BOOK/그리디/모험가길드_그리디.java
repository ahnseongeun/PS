package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1 2 2 2 3
public class 모험가길드_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(input.readLine());
        StringTokenizer st=new StringTokenizer(input.readLine());
        int arr[]=new int[n];
        int cnt=1;
        int group_cnt=0;
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        /*
        현재 그룹에 필요한 인원과 현재까지 그룹에 포함된 인원이 일치하면 그룹수 추가
         */
        for(int i=0;i<n;i++){
            if(arr[i]<=cnt){
                group_cnt++;
                cnt=1;
            }else{
                cnt++;
            }
        }
        System.out.println(group_cnt);


    }
}
