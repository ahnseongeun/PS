package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
black	0	1
brown	1	10
red	2	100
orange	3	1000
yellow	4	10000
green	5	100000
blue	6	1000000
violet	7	10000000
grey	8	100000000
white	9	1000000000
 */
public class 저항_1076 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,int[]> register = new HashMap<>();
        register.put("black",new int[]{0,1});
        register.put("brown",new int[]{1,10});
        register.put("red",new int[]{2,100});
        register.put("orange",new int[]{3,1000});
        register.put("yellow",new int[]{4,10000});
        register.put("green",new int[]{5,100000});
        register.put("blue",new int[]{6,1000000});
        register.put("violet",new int[]{7,10000000});
        register.put("grey",new int[]{8,100000000});
        register.put("white",new int[]{9,1000000000});
        long n1 = register.get(input.readLine())[0] * 10;
        long n2 = register.get(input.readLine())[0];
        long n3 = register.get(input.readLine())[1];
        System.out.println((n1 + n2) * n3);
    }
}
