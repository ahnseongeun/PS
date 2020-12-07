package 이것이코딩테스트다_BOOK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무지의먹방라이브_그리디 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(input.readLine());
        int food_times[]={3,1,2,1,1,1,3};
        int size=food_times.length;
        int idx=0;
        int cnt=0;
        boolean flag=false;
        while(cnt!=k) {
            cnt++;
            idx%=size;
            if (food_times[idx] == 0) {
                idx++;
                int count = 1; //비어있는 그릇의 수
                while (true) {
                    count++;
                    if (food_times[idx%size] != 0){
                        food_times[idx]--;
                        idx++;
                        break;
                    }else{
                        idx++;
                    }
                    if (count == size) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    idx = -1;
                    break;
                }
            }else {
                food_times[idx]--;
                idx++;
            }
        }
        System.out.println(idx%food_times.length+1);
    }

}
