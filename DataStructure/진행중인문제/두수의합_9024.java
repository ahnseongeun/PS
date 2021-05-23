package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4
10 8
-7 9 2 -4 12 1 5 -3 -2 0
10 4
-7 9 2 -4 12 1 5 -3 -2 0
4 20
1 7 3 5
5 10
3 9 7 1 5
 */
/*
1
10 4
-7 -4 -3 -2 0 1 2 5 9 12
 */
public class 두수의합_9024 {

    /**
     * 1. 정렬
     * 2. sum이 k보다 크고 min 보다 작으면 min을 sum으로 교체 후, cnt 초기화
     * 3. sum += arr[start]
     * @param arr
     * @param k
     */
    private static int getCount(int[] arr, int k) {

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;
        int cnt = 1;
        int min = Integer.MAX_VALUE;

        //8
        //-7 -4 -3 -2 0 1 2 5 9 12
        while(start < end){

            sum = Math.abs(arr[start] + arr[end]);

            //sum - k의 절대 값이 낮을 것을 기준으로 판별
            if(Math.abs(sum - k) < min){
                min = Math.abs(sum - k);
                cnt = 1;
            }else if(Math.abs(sum - k) == min){
                cnt++;
            }

            //투 포인터의 방향 전환을 할 때는 sum과 k로 결정
            if(sum >= k){
                end--;
            }else{
                start++;
            }

        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(input.readLine());

            for(int j = 0; j < n ; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            System.out.println(getCount(arr, k));
        }
    }
}
