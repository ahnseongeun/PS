package DataStructure.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N보다 크거나 같고 큰 소수이면서 팰린드롬인 수 찾기
1. 소수를 찾아놓는다.
2. 팰린드롬인지 찾는다.
 */
public class 소수팰린드롬_1747 {

    static final int SIZE = 1003001;
    static boolean[] check;
    static boolean checkEqualString(int number) {

        String str = String.valueOf(number);
        int end = str.length() - 1;
        for( int i = 0; i <= str.length() / 2; i++) {
            if(str.charAt(i) == str.charAt(end - i)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        check = new boolean[SIZE + 1];
        check[1] = true;
        //소수 찾기
        //SIZE가 100일 때 Math.sqrt(SIZE)를 하게되면 10인데 어떻게 소수를 표시하는 것일까?
        //-> 이렇게 하는 방식은 모든 수는 소수이고 i부터 Math.sqrt(SIZE)까지 포함되는 배수를 제거해서 소수를 남기는 방식이다.
        for(int i = 2; i <= Math.sqrt(SIZE); i++) {
            if(check[i]) continue;
            for(int j = i + i; j <= SIZE; j += i) {
                check[j] = true;
            }
        }

        //소수라면 팰린드롬 진행 -> 소수는 false
        int result = 0;
        for(int i = n; i <= SIZE; i++) {
            if(check[i]) continue;
            if(checkEqualString(i)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
