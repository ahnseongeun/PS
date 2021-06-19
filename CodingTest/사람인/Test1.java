package CodingTest.사람인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Test1 {

    private static String getHappyNumber(int n) {

        int num = n;
        Set<Integer> set = new HashSet<>();

        while(set.add(n)){
            if(n == 1)
                return num + " is Happy Number.";
            int sum = 0;
            while(n != 0){
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return num + " is UnHappy Number.";
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        System.out.println(getHappyNumber(n));
    }
}
