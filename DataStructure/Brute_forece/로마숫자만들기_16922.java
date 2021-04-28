package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * 순서가 상관이 있다면 경우의 수는 4 ^ N 이다.
 * 하지만 순서가 상관 없기 때문에 I만 N가지, L 만 N가지 이렇게 총 4가지 N ^ 4의 경우의 수라고 볼 수 있다.
 */
public class 로마숫자만들기_16922 {

    private static int n;
    private static int[] sumArr;
    private static int[] arr = {1, 5, 10, 50};

    //idx가 필요한 이유 순서가 상관 없으면 idx를 통해서 중복되지 않게 제어 해줘야 한다.
    //idx가 있으면 1 5 5 5 와 5 1 5 5 이렇게 2가지가 발생해서 이것을 제어 해준다.
   private static void calSum(int sum, int idx ,int level) {
        if(level == n) {
            sumArr[sum] = 1;
            return;
        }

        for(int i = idx; i < 4; i++){
            calSum(sum + arr[i], idx,level + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        int a[] = {1,5,10,50};
        sumArr = new int[1001];

        calSum(0,0,0);
        //Arrays.stream(sumArr).forEach(System.out::println);
        System.out.println(Arrays.stream(sumArr).filter(value -> value == 1).count());
    }
}
