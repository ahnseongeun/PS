package CodingTest.식스샵;

public class Test3 {
    private static int solution(int n) {
        if(n % 5 == 0) return n / 5;
        int cnt = 0;
        while(n >= 0){
            n -= 3;
            cnt++;
            if( n % 5 == 0) return cnt + (n / 5);
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 159;
        for(int i = 3; i < 10000; i++)
            System.out.println(i + " " + solution(i));
    }
}
