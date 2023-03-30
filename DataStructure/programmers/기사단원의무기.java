package DataStructure.programmers;

public class 기사단원의무기 {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        int result = 0;
        for ( int i = 1; i <= number; i++) {
            int primeCount = getPrimeNumberCount(i);
            result += primeCount > limit ? power : primeCount;
        }
        System.out.println(result);
    }

    private static int getPrimeNumberCount(int num) {
        int cnt = 0;
        for ( int i = 1; i * i <= num; i++) {
            if ( i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        return cnt;
    }
}
