package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 이 문제의 N값은 40인데 부분 수열은 포함하고 안포함하고의 경우가 있어서 2^40의 경우의 수가 발생해서 1조이다.
 * 즉, 이 문제는 완전탐색으로는 풀 수 없는 문제이다.
 * 그럼 어떻게 접근해야 할까? 40을 절반으로 나누고 각각의 부분 수열의 합을 구한다.
 * 그 후 정렬후 한쪽은 idx 0 부터 다른 한쪽은 idx n부터 비교를 하면서 모든 합을 구한다.
 */
/*
5 0
-7 -3 -2 5 8
5 3
1 2 3 4 5
 */
public class 부분수열의합2_1208 {

    //private static ArrayList<Integer> sum1;
    //private static ArrayList<Integer> sum2;
    static ArrayList<Integer> sum1 = new ArrayList<>();
    static ArrayList<Integer> sum2 = new ArrayList<>();
    private static int[] arr;
    private static long result = 0;
    private static int k;

    // 1,2 ,3 - 0 1 2 3 12 13 23 123
    private static void subPermutation(int idx, int end, int sum, ArrayList<Integer> list) {
        if(idx == end){
            list.add(sum);
            return;
        }
        //idx를 더해주지 않은 sum
        subPermutation(idx + 1, end, sum + arr[idx], list);
        //idx를 더해준 sum
        subPermutation(idx + 1, end, sum , list);
    }



    private static void searchTarget() {
        int size1 = sum1.size();
        int size2 = sum2.size();

        int start = 0;
        int end = size2 - 1;
        //범위를 지정하는 방법,
        while(start < size1 && end >= 0){ //start < size1 과 같거나, end가 -1이 되는 순간 끝!

            int element1 = sum1.get(start);
            int element2 = sum2.get(end);
            if(element1 + element2 == k){
                long count1 = 0;
                long count2 = 0;

                //start < size1 && element1 == sum1.get(start++)
                //이렇게 해버리면 조건이 안맞아도 ++이 진행되기 때문에 조건을 만족하면 ++을 하도록 해야한다.
                while(start < size1 && element1 == sum1.get(start)){
                    start++;
                    count1++;
                }
                while(end >= 0 && element2 == sum2.get(end)){
                    end--;
                    count2++;
                }

                //부분 수열의 경우의 수는 *를 해줘야한다.
                result += count1 * count2;
            }
            if(element1 + element2 < k){
                start++;
            }
            if(element1 + element2 > k){
                    end--;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        subPermutation(0,n / 2,0,sum1);
        subPermutation(n / 2,n,0,sum2);
        Collections.sort(sum1);
        Collections.sort(sum2);


        //여기서 투포인터로 값을 좁혀가면서 있는지 확인

        searchTarget();

        //k가 0이라면 하나를 빼줘야 하는데 왜냐하면 최소 1개를 선택해야 하고 0,0 을 택하는 경우를 없애야 하기 때문이다.
        System.out.println(k == 0 ? result - 1 : result);
    }
}
