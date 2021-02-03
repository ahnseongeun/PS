package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 모듈러의 속성
 * 이 문제를 풀기 위해서는 모듈러 연산의 속성에 대해 알고 있어야 했습니다.
 *
 * 모듈러 연산의 속성은 아래와 같습니다.
 *
 * 1. (a + b) mod n = {(a mod n) + (b mod n)} mod n
 *
 * 2. (a - b) mod n = {(a mod n) - (b mod n)} mod n
 *
 * 3. (a * b) mod n = {(a mod n) * (b mod n)} mod n
 *
 *
 *
 */
public class Hashing {

    public static void main(String[] args) throws  Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String str = input.readLine();
        long sum = 0;
        long mul = 1;
        int mod = 1234567891;
        for(int i = 0; i < str.length(); i++){
            int value = str.charAt(i) - 'a' + 1;
            sum += value * mul;
            mul *= 31;
            sum %= mod;
            mul %= mod;
        }
        System.out.println(sum);
    }
}
