package DataStructure.진행중인문제;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6
10 20 10 30 20 50
6
8 5 1 10 5 9
 */
public class 가장긴증가하는부분수열2_12015 {

    //private static int arr[];


    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n; i++) {
            //value에 현재 비교해야 할 값 넣기
            //StringBuilder sb = new StringBuilder();
            int value = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = list.size() - 1;
            //sb.append(end +"\n");

            if (list.get(end) < value) { //마지막 값보다 value가 더 크다면 list에 추가
                list.add(value);
            } else{
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
            //list.forEach(integer -> sb.append(integer+" "));
            //System.out.println(sb);
        }
        System.out.println(list.size() - 1);

    }
}
