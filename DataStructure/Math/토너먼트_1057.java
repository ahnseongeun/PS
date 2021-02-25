package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 입력받은 두 인덱스를 /2 하면서 같이질때 while문을 탈출 한다
 * 같은 경우를 빼줘야 하기 때문에 -1 해준다.
 */
public class 토너먼트_1057 {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());

        int count = 1;
        while(true){

            if(kim == im) {
                count--;
                break;
            }
            kim = (int) Math.round(kim / 2.0);
            im = (int) Math.round(im / 2.0);
            //System.out.println(kim + " " + im);
                count++;
        }
        System.out.println(count);
    }
}
