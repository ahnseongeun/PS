package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로마숫자만들기_16922 {

    private static int letter[] = {1,5,10,50};
    private static boolean arr[];
    private static int n;
    private static int result = 0;

    private static void searchLetter(int idx, int bound,int sum) {

        if(idx == n){
            if(arr[sum])
                return;
            arr[sum] = true;
            result++;
            return;
        }

        //1 2 3 4 / 2 1 4 3은 똑같다고 볼 수 있기 때문에 bound를 이용해서 중복된 순열은 제거한다.
        for(int i = bound; i < 4; i++){
            searchLetter(idx + 1, i,sum + letter[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        arr = new boolean[1001];
        n = Integer.parseInt(input.readLine());

        searchLetter(0,0,0);
        System.out.println(result);
    }
}
