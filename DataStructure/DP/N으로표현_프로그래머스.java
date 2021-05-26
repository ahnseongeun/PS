package DataStructure.DP;

/*
1 - 5 / 5 dp[1] = 2;
2 - 5 / 5 + 5 / 5 = 4;


 */
public class N으로표현_프로그래머스 {

    private static int answer;
    private static void getNumberSet(int n, int sum ,int idx,int number){

        if(idx > 8)
            return;

        answer++;
        //더하기
//        getNumberSet(n,sum + n , idx + 1, number);
//        //빼기
//        getNumberSet(n,sum - n , idx + 1, number);
//        //나누기
//        getNumberSet(n,sum / n , idx + 1 , number);
//        //곱하기
//        getNumberSet(n,sum * n , idx + 1, number);
//        //합치기
//        getNumberSet(n,sum * 10 + n , idx + 1, number);

        int temp = 0;
        for(int i = 1 ; i <= 8; i++) {
            temp = temp * 10 + n;
            //더하기
            getNumberSet(n, sum + n, idx + i, number);
            //빼기
            getNumberSet(n, sum - n, idx + i, number);
            //나누기
            getNumberSet(n, sum / n, idx + i, number);
            //곱하기
            getNumberSet(n, sum * n, idx + i, number);
        }


    }
    public static int solution(int N, int number) {
        answer = 0;
        getNumberSet(N,0,1,number);
        return answer;
    }

    public static void main(String[] args){
        int n = 5;
        int number = 12;
        System.out.println(solution(n,number));
    }
}
