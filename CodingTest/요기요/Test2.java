package CodingTest.요기요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1000000000
public class Test2 {
    public static void main(String[] args) throws Exception{
        int N = 98;
        StringBuilder sb = new StringBuilder();
        char[] numbers = new char[10];
        Arrays.fill(numbers,'0');
        String number = String.valueOf(N + 1);
        int idx = 9;
        for(int i = number.length() - 1; i >= 0; i--){
            numbers[idx--] = number.charAt(i);
        }
        boolean check = false;
        while(!check){

            for(int i = 0; i < numbers.length - 1; i++){
                int ch1 = numbers[i] - '0';
                int ch2 = numbers[i + 1] - '0';
                if(ch1 == ch2){
                    if(ch1 == 0) continue;
                    if(ch1 == 9){
                        int num = 0;
                        for(int j = i ; j < numbers.length; j++){
                            numbers[j] = (char)('0' + (num++ % 2));
                        }
                        numbers[i - 1] = (char)(numbers[i - 1] + 1);
                        break;
                    }else{
                        numbers[i + 1] = (char)(numbers[i] + 1);
                        int num = 0;
                        for(int j = i + 2; j < numbers.length; j++){
                            numbers[j] = (char)('0' + (num++ % 2));
                        }
                        check = true;
                        break;
                    }
                }
            }
        }

        for(int i = 0 ; i < 10; i++)
            sb.append(numbers[i]);
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
