package CodingTest.godo;

import java.util.LinkedList;
import java.util.Queue;
/*
* 여 페이지 번호를 눌러야 한다. 그리고 나서 '+'와 '-' 버튼을 눌러서 원하는 페이지로 이동해야 한다.

문제에서는 원하는 페이지 번호 int page과 고장난 숫자 버튼들 정수 배열 int[] broken이 주어진다. 원하는 페이지로 가기 위해서 버튼을 눌러야 하는 최소한의 횟수를 리턴하시오.

참고 / 제약 사항
page는 최소값 0, 최대값 500,000의 범위를 가진다.
broken은 0개 이상, 10개 이하의 요소를 가진다.
broken의 각 요소는 최소값 0, 최대값 9의 범위를 가진다.
broken에 중복되는 요소는 없다.
테스트 케이스
int page = 5457
int[] broken = [6,7,8]리턴(정답): 6
5457로 가기 위해 "5 4 5 5 + +" 를 누르거나 "5 4 5 9 - -"를 누를 수 있다.

int page = 100
int[] broken = [1,0,5]리턴(정답): 0
처음 시작하는 페이지가 100이므로 아무것도 누르지 않아도 된다.

int page = 99999
int[] broken = [0,2,3,4,5,6,7,8,9]리턴(정답): 11118
int page = 158
int[] broken = [1,9,2,5,4]리턴(정답): 58
int page = 151241
int[] broken = [0,1,2,3,4,7,8,9]리턴(정답): 84580*/
public class godo2 {
    public static void main(String[] args) throws Exception{
        int page=5457;
        int page_size=String.valueOf(page).length();
        int max=Math.abs(page-100); //+,-로 이동할수 있는 길이 계산
        int[] broken = {6,7,8};
        int broken_size=broken.length;
        boolean remote[]=new boolean[10];
        if(broken.length!=0) {
            for(int i=0;i<broken_size;i++)
            {
                remote[broken[i]]=true; //true면 고장난것
            }
        }
        for(int i=0;i<=999999;i++)
        {
            String s=String.valueOf(i);
            boolean flag=false;
            int sum=0;
            for(int j=0;j<s.length();j++)
            {
                int c=s.charAt(j)-'0';
                sum++;
                if(remote[c]==true)
                {
                    flag=true;
                    break;
                }
            }
            if(flag==false)
            {
                sum+=Math.abs((page-i));
                sum=Math.abs(sum);
                if(max>sum)
                    max=sum;
            }
        }
        System.out.println(max);
    }
}
