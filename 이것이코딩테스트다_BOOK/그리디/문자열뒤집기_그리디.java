package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
첫번째 접근법
길이가 최대 백만이면 0과1을 뒤집는 최대의 경우가 logN이기 때문에 최대 20번정도 계산이 소요된다고 생각하면 된다.
즉, 백만*20=2억번이여서 딱 2초가 걸린다.
그러면 그리디 답게 가장 최선이 되는 방법은 무엇일까?
1. 0이 가장 많은 구간 뒤집기
2. 전체 뒤집기
1번과 2번의 1의 개수를 비교한다.
다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
 */
public class 문자열뒤집기_그리디 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str=input.readLine();
        char chars[]=str.toCharArray();
        int cnt=0;
        //001100101
        boolean flag=false;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]!=chars[i+1]) { //두 문자가 다른 경우
                if(flag){
                    flag=false;
                }else{
                    cnt++;
                    flag=true;
                }
            }
        }
        System.out.println(cnt);
    }
}
