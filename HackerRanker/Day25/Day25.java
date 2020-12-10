package HackerRanker.Day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day25 {
        static String checkPrime(int n){
            if(n==2||n==3)
                return "Prime";
            for(int i=2;i<=Math.sqrt(n)+1;i++){
                if(n%i==0)
                    return "Not prime";

                if(i==(int)Math.sqrt(n))
                    return "Prime";
            }
            return "Not prime";
        }
        public static void main(String[] args) throws Exception{
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(input.readLine());
            for(int i=0;i<t;i++){
                int n=Integer.parseInt(input.readLine());
                System.out.println(checkPrime(n));
            }
        }
}
