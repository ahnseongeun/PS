package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 10 20 1 2 3 4
 */
public class 가장긴증가하는부분수열3_12738 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1000000001);
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = list.size() - 1;

            if(list.get(end) < value){
                list.add(value);
            }else{
                int mid = 0;
                while(start < end){
                    mid = (start + end) / 2;
                    if(list.get(mid) < value){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                list.set(end,value);
            }
        }
        System.out.println(list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < list.size(); i++)
            sb.append(list.get(i)+" ");
        System.out.println(sb);
    }
}
