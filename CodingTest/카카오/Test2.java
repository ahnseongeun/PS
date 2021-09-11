package CodingTest.카카오;

import java.util.ArrayList;

public class Test2 {

    static String getTranslate(int n, int k ) {

        StringBuilder sb = new StringBuilder();

        while(n != 0) {
            long remainder = n % k;

            if(remainder > 9) {
                sb.append((char)(remainder + 55));
            } else {
                sb.append(remainder);
            }

            n /= k;
        }
        return sb.reverse().toString();
    }

    private static int getPrime(String number) {

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if(ch == '0') {
                if(sb.length() == 0) continue;
                long prime = Long.parseLong(sb.toString());
                if(isPrime(prime)) cnt++;
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }

        if(sb.length() != 0) {
            int prime = Integer.parseInt(sb.toString());
            if(isPrime(prime)) cnt++;
        }

        return cnt;
    }

    private static boolean isPrime(long num) {
        boolean result = true;
        if(num == 1L) return false;
        long end = (long) Math.sqrt(num);
        for(int i = 2; i <= end; i++) {
            if( num % i == 0) {
                result = false;
                break;
                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
            }
        }
        return result;

    }

    public static void main(String[] args) {

        int n = 437674;
        int k = 3;
        String number = getTranslate(n , k);
        System.out.println(number);
        System.out.println(getPrime(number));
    }
}
