package DataStructure.BinarySearch;

import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 11
802
743
457
539
 */
public class 랜선자르기_1654 {
    static int[] wire;
    static int target;
    private static long BinarySearch(long start,long end) {
        long mid = (start + end) / 2;

        //이분탐색은 이것이 핵심
        if(start>end)
            return mid;

        int count = 0;
        for(int i = 0; i < wire.length; i++)
            count += wire[i]/mid;

        if(count >= target){
            return BinarySearch(mid+1 , end);
        }else{
            return BinarySearch(start , mid-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int k = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        wire = new int[k];
        for(int i = 0;i < k;i++)
            wire[i] = Integer.parseInt(input.readLine());

        long result = BinarySearch(0,Integer.MAX_VALUE);
        System.out.println(result);
    }
}
