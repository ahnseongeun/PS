package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 통계학_2108 {
    static int[] frequency;

    private static int  max_min(int[] arr) {
        return arr[arr.length-1] - arr[0];
    }

    private static int  countMax(int[] arr) {
        //중복된 수를 count하고 가장 다루기 쉽게 만드는 자료구조는?
        //값으로 필터링
        TreeMap<Integer,Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

        int max = 0;

        for(int num : arr){
            int var = map.getOrDefault(num,0)+1;
            max = Math.max(max,var);
            map.put(num,var);
        }

        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer, Integer> set:map.entrySet()){ //특정 값인 key를 뽑아내고 s
            if(set.getValue() == max){
                list.add(set.getKey());
            }
        }
        Collections.sort(list);

        return list.size() > 1 ? list.get(1) : list.get(0);
    }

    private static int  midValue(int[] arr) {
        return arr[arr.length/2];
    }

    private static int arithmeticMean(int[] arr) {
        double sum = 0;
        int size = arr.length;
        for(int num:arr)
            sum += num;
        sum /= size;
        return (int) Math.round(sum);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(input.readLine());
        frequency = new int[4001];

        Arrays.sort(arr);
        sb.append(arithmeticMean(arr)).append("\n");
        sb.append(midValue(arr)).append("\n");
        sb.append(countMax(arr)).append("\n");
        sb.append(max_min(arr)).append("\n");
        System.out.println(sb);
    }
}
