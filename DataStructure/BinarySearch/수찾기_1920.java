package DataStructure.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
4 1 5 2 3
5
1 3 7 9 5
단순히 배열에 원소가 들어 있는 방법을 찾는 것은
이분 탐색으로 찾는 것도 좋지만
 N(1 ≤ N ≤ 100,000) 이므로 Hashset을 이용해서 찾는것도 좋다.
 */
public class 수찾기_1920 {
    static int arr[];
    private static boolean containElement(int start, int end, int target) {
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] == target){
                return true;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        arr = new int[n];
        for(int i = 0;i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int m =Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(containElement(0,n-1,num))
                sb.append(1+"\n");
            else
                sb.append(0+"\n");
        }
        System.out.println(sb);
    }
}
