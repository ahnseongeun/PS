package 이것이코딩테스트다_BOOK.이진탐색;

import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정렬되어있다 -> 이진 탐색으로
public class 정렬된배열에서특정수의개수구하기_이진탐색 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int arr[]=new int[n];

        st=new StringTokenizer(input.readLine());
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        int start=0;
        int end=arr.length-1;
        int count=0;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]<x) {
                start = mid + 1;
            }else if(arr[mid]>x){
                end = mid - 1;
            }else{
                count++;
                int left_idx=mid-1;
                int right_idx=mid+1;
                while(true){
                    if(left_idx>-1&&arr[left_idx--]==x){
                        count++;
                    }else if(right_idx< arr.length&&arr[right_idx++]==x){
                        count++;
                    }else{
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(count==0?-1:count);
    }
}
