package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 통계학_2108 {
    static int frequency[];

    private static int  max_min(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1] - arr[0];
    }

    private static int  countMax(int[] arr) {
        //중복된 수를 count하고 가장 다루기 쉽게 만드는 자료구조는?
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> list = new LinkedList<>();
        map.forEach((integer, integer2) -> list.add(new int[]{integer,integer2}));

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1] >= o1[1]){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        list.forEach(ints -> System.out.println(ints[0]+" "+ints[1]));
        return list.size()>1?list.get(1)[0]:list.get(0)[0];
    }

    private static int  midValue(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    private static int arithmeticMean(int[] arr) {
        int sum = 0;
        int size = arr.length-1;
        for(int num:arr)
            sum += num;
        sum /= size;
        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(input.readLine());
        frequency = new int[4001];

        sb.append(arithmeticMean(arr)+"\n");
        sb.append(midValue(arr)+"\n");
        sb.append(countMax(arr)+"\n");
        sb.append(max_min(arr)+"\n");
        System.out.println(sb);
    }
}
