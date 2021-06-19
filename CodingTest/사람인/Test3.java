package CodingTest.사람인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//5 1 1
public class Test3 {

    private static ArrayList<Integer> array;

    private static long solution(int a, int b, int n) {

        long val = 1983;
        long sum = val;

        for(int i = 1; i < n; i++){
            val = val * (a + b) % 20090711;
            int index = binarySearch((int)val);
            array.add(index, (int) val);
            //System.out.println(array);
            //짝수
            if(array.size() % 2 == 0){
                sum += Math.min(array.get(array.size() / 2),array.get((array.size() / 2) - 1));
            //홀수
            }else{
                sum += array.get(array.size()/ 2);
            }
        }
        return sum;
    }

    private static int binarySearch(int val) {

        int mid = 0;
        int left = 0;
        int right = array.size() - 1;

        while(right >= left){
            mid = (left + right) / 2;
            if(val == array.get(mid)){
                return mid;
            }

            if(array.get(mid) > val){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        array = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        array.add(1983);

        System.out.println(solution(a,b,n));
    }
}
