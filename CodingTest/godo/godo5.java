package CodingTest.godo;

import java.util.Arrays;
import java.util.Collections;

/*주어진 int[] votes에서 i번째 요소는 원래 후보 i에게 투표하려고 생각했던 사람의 수이다. 당신이 원하는 후보 0이 다른 후보들보다 더 많이 득표하기 위해 반드시 바꿔야 하는 투표의 최소 숫자를 반환하여라.

        참고 / 제약 사항
        votes는 1개 이상, 50개 이하의 요소를 가진다.
        votes의 각 요소는 1 이상, 100 이하이다.
        테스트 케이스
        int[] votes = [5,7,7]리턴(정답): 2
        다른 두 후보에게서 1표씩 산다면 후보 0이 7표가 되고 나머지 두 후보는 6표가 된다.

        int[] votes = [10,10,10,10]리턴(정답): 1
        후보 0의 투표수는 다른 후보들의 투표수를 초과해야 한다. 따라서 한표만 더 있으면 된다.

        int[] votes = [1]리턴(정답): 0
        후보 0이 유일한 후보라면 표를 사지 않아도 된다.

        int[] votes = [5,10,7,3,8]리턴(정답): 4
        int[] votes = [100]리턴(정답): 0*/
public class godo5 {
    public static void main(String[] args) throws Exception{
        int votes[]={1,2,5,5,5};
        int start=votes[0];
        int idx=1;
        int count=0;
        while(true){
            boolean flag=true;
            for(int i=1;i<votes.length;i++){
                if(start<votes[i]){
                    flag=false;
                    break;
                }
            }
            if(flag)
                break;
            Arrays.sort(votes,1,votes.length);
            for(int i=votes.length-1;i>0;i--){
                if(start<votes[i]){
                    start++;
                    votes[i]--;
                    count++;
                    break;
                }
            }
        }
        for(int i=1;i<votes.length;i++) {
            if (start == votes[i]) {
                System.out.println(count+1);
                break;
            }else{

            }
        }
        System.out.println(count);
    }

}
