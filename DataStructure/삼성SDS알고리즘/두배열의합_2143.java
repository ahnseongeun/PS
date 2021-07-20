package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

import static java.util.Collections.reverseOrder;

/*
5
4
1 3 1 2
3
1 3 2
 */
public class 두배열의합_2143 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(input.readLine());

        int n1 = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++) arr1[i] = Integer.parseInt(st.nextToken());
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            int sum = 0;
            for(int j = i; j < n1 ; j++) {
                sum += arr1[j];
                list1.add(sum);
            }
        }

        int n2 = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++) arr2[i] = Integer.parseInt(st.nextToken());
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < n2; i++) {
            int sum = 0;
            for(int j = i; j < n2 ; j++) {
                sum += arr2[j];
                list2.add(sum);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2, reverseOrder());

        //투포인터를 이용해서 target과 일치하는 부분 배열 합 구하기
        int start = 0;
        int end = 0;
        long count = 0;

        while(true) {

            if(start == list1.size() || end == list2.size()) break;

            int left_value = list1.get(start);
            int right_value = list2.get(end);

            if(left_value + right_value > target) {
                end++;
            } else  if(left_value + right_value < target) {
                start++;
            } else {
                long cnt1 = 0;
                while(start < list1.size() && list1.get(start) ==  left_value) {
                    start++;
                    cnt1++;
                }

                long cnt2 = 0;
                while(end < list2.size() && list2.get(end) == right_value) {
                    end++;
                    cnt2++;
                }

                if(left_value + right_value == target) {
                    count += (cnt1 * cnt2);
                }
            }
        }
        System.out.println(count);
    }
}
