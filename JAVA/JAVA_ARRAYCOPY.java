package JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JAVA_ARRAYCOPY {
    private static void display(int arr[][]){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j< arr.length;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args){
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int arr[][]={{1,2,3},{1,2,3},{1,2,3}};
        display(arr);

        /**
         * 깊은 복사 하는법
         * 2차원 배열일 경우 각 행마다 clone을 해줘야 한다.
         */
        int arr1[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            arr1[i]= arr[i].clone();

        /**
         * 깊은 복사 하는법
         * 2차원 배열일 경우 각 행마다 copy를 해줘야 한다.
         */
        int arr2[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            arr2[i]=Arrays.copyOf(arr[i],arr.length);

        arr1[0][0]+=5;
        arr[0][0]+=3;
        display(arr1);
        display(arr2);
        display(arr);

    }
}
