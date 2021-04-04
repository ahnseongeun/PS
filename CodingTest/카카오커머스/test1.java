package CodingTest.카카오커머스;

import java.util.Arrays;

public class test1 {

    private static int minCount;
    private static int k;

    private static int[] swap(int idx, int i, int[] numbers){
        StringBuilder sb = new StringBuilder();
        int tmp = numbers[idx];
        numbers[idx] = numbers[i];
        numbers[i] = tmp;
        Arrays.stream(numbers).forEach(value -> sb.append(value+" "));
        System.out.println(sb);
        return numbers;
    }

    private static void minSwap(int idx, int[] numbers, int cnt) {
        int size = numbers.length;
        if(idx == size) {
            minCount = cnt;
            return;
        }

        for(int i = idx; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(!check(swap(i,j,numbers))){
                    minCount = cnt;
                    return;
                }else{
                    minSwap(idx + 1,swap(i,j,numbers),cnt + 1);
                }
            }
        }
    }

    private static boolean check(int[] numbers) {
        for(int i = 0; i < numbers.length - 1; i++)
            if(Math.abs(numbers[i] - numbers[i + 1]) > k) //큰것이 있다면 true
                return true;
        return false;
    }

    public static void main(String[] args) {
        int numbers[] = {3, 7, 2, 8, 6, 4, 5, 1};
        k = 3;
        minCount = 0;
        minSwap(0, numbers, 0);
        //스왑이 최소가 되는 것을 구한다.
        System.out.println(minCount);
    }
}
