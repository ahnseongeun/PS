package HackerRanker;

import java.util.Scanner;

public class Day20 {
        static int count=0;
        public static int[] Swap(int[] a,int idx1,int idx2){
            int temp=a[idx1];
            a[idx1]=a[idx2];
            a[idx2]=temp;
            return a;
        }
        public static int[] BubbleSort(int[] a){
            int size=a.length;
            for(int i=0;i<size-1;i++){

                for(int j=0;j<size-i-1;j++){
                    if(a[j]>a[j+1]) {
                        a = Swap(a, j, j + 1);
                        count++;
                    }
                }
            }
            return a;
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            // Write Your Code Here
            BubbleSort(a);
            System.out.println("Array is sorted in "+count+" swaps.");
            System.out.println("First Element: "+a[0]);
            System.out.println("Last Element: "+a[a.length-1]);
        }
}
