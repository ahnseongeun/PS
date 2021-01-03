package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 왕실의나이트 {
    private static int locationCheck(int x, int y) {
        int cnt=0;
        int next_x=0;
        int next_y=0;
        int dx[]={2,-2,1,-1};
        int dy[]={1,-1,2,-2};
        int direction[][]={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        for(int i=0;i<8;i++){
            next_x=x+direction[i][0];
            next_y=y+direction[i][1];
            if(next_x<1||next_x>8||next_y<1||next_y>8)
                continue;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String location=input.readLine();
        int x=location.charAt(0)-'a'+1;
        int y=location.charAt(1)-'1'+1;
        int count=locationCheck(x,y);
        System.out.println(count);
    }
}
