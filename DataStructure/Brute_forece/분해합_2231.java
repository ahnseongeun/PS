package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분해합_2231 {
    private static int divideSum(int temp) {
        int sum=0;
//        String str=String.valueOf(num);
//        for(int i = 0;i < str.length();i++)
//            sum += str.charAt(i)-'0';
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws  Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(input.readLine());
        int result=0;
        for(int i=1;i<=target;i++){
            if(target==divideSum(i)+i){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}
