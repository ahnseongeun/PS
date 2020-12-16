package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 6
19 15 10 17
최대 떡의 길이가 10억 까지 이기 때문에 이분탐색을 생각해야한다.
10억은 log2^30 = 10억 -> 대략 30번만에 탐색 가능하다.
떡의 최대 개수는 1000000개 이므로 탐색마다 떡의 갯수를 구한다고 하면 3천만의 계산이 요구된다.
1초에 1억 계산한다고 가정하면 통과 가능한 시간이다.
이분탐색 + 순차탐색을 요구하는 문제이다.
*/

public class 떡볶이떡만들기 {

    static int m = 0;

    private static int BinarySearch(int[] riceCakeList, int start,int end,int max) {
        int mid= (start+end)/2;
        if(start>end) {
            return max;
        }else{
            int length=presentLength(riceCakeList,mid); //현재 높이의 떡 길이 반환

            if(length<m){ //현재 떡의 길이가 목표 떡의 길이보다 작으면 end값을 줄여서 떡의 길이를 늘려야한다.
                return BinarySearch(riceCakeList, start, mid-1, max);
            }else if(length==m){
                max=mid;
                return max;
            }else{  //현재 떡의 길이가 목표 떡의 길이보다 크다면 end값을 늘려서 떡의 길이를 줄여야한다.
                max=mid;
                return BinarySearch(riceCakeList, mid+1, end, max);
            }
        }
    }

    private static int presentLength(int[] riceCakeList,int mid) {
        int sum=0;
        for(int i=0;i<riceCakeList.length;i++){
            int temp=riceCakeList[i]-mid;
            if(temp>=0){
                sum+=temp;
            }
        }
        return sum;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken()); //떡의 갯수
        m=Integer.parseInt(st.nextToken()); //요청한 떡의 길이
        int RiceCakeList[]=new int[n];
        st= new StringTokenizer(input.readLine());

        for(int i=0;i<n;i++)
            RiceCakeList[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(RiceCakeList);

        int result=BinarySearch(RiceCakeList,0,RiceCakeList[RiceCakeList.length-1],0);
        System.out.println(result);
    }
}
