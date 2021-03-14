package CodingTest.다날;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TEST1 {

    public static void main(String[] args) throws Exception{
        int n = 6;
        long minDay = (n / 7 * 2) + ((n % 7 == 6) ? 1 : 0); //+ ((  (n % 7 == 0) ? 2 : 0));
        long maxDay = (n / 7 * 2) + ((n % 7 >= 1) ? 1 : 0) + (((n % 7) >= 2 ? 1 : 0));
        System.out.println(minDay);
        System.out.println(maxDay);
        StringBuilder sb = new StringBuilder();
    }
}
