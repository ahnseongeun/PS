package CodingTest.카카오모빌리티;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) throws Exception{
        int[] T = {0,0};
        int[] A = {0};
        Arrays.sort(A);
        Set<Integer> set = new HashSet<>();

        for(int i = A.length - 1; i >= 0; i--){
            int num = A[i];
            while(set.add(num)){
                num = T[num];
            }
        }
        System.out.println(set.size());
    }
}
