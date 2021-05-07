package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 방번호_1475 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        int arr[] = new int[9]; //0 ~ 8
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            arr[num == 9 ? 6 : num]++;
        }
        arr[6] = arr[6] == 1 ? arr[6] : (int) Math.round(arr[6] / 2.0);
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
