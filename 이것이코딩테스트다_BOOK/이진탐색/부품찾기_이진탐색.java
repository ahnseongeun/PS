package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/*
5
8 3 7 9 2
3
5 7 9
N개의 제품 (1 <= N <= 1000000)
각 부품은 정수 형태의 고유한 번호 (1 <= 정수 <= 10^6)
손님이 M개의 종류의 부품을 대량 구매 (1 <= M <= 100000)
가게 안에 M개의 부품이 있는지 확인하는 방법 (1 <= 정수 <= 10^6)
 */
public class 부품찾기_이진탐색 {
    private static String requestListSearch(int[] item_list, int[] request_list) {
        for(int i=0;i<request_list.length;i++){
            if(!BinarySearch(item_list,request_list[i])) {
                System.out.println(request_list[i]);
                return "NO";
            }
        }
        return "YES";
    }

    private static boolean BinarySearch(int[] item_list, int requestItem) {
        int start=0;
        int end=item_list.length-1;
        while(start<=end){
            int mid= (start+end) /2;
            if(requestItem>mid){
                start=mid+1;
            }else if(requestItem==mid){
                return true;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int item_list[]=new int[n];
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=0;i<item_list.length;i++){
            item_list[i] = Integer.parseInt(st.nextToken());
        }

        int m=Integer.parseInt(input.readLine());
        int request_list[]=new int[m];
        st=new StringTokenizer(input.readLine());
        for(int i=0;i<request_list.length;i++){
            request_list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(requestListSearch(item_list,request_list));
    }
}
