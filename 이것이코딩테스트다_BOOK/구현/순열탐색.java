package 이것이코딩테스트다_BOOK.구현;

import java.util.ArrayList;

public class 순열탐색 {

    static ArrayList<Integer> list;

    private static void calSearch(int start, int count, int m) {
        if(count==m){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<list.size();i++)
                sb.append(list.get(i)+" ");
            sb.append("\n");
            System.out.println(sb);
            return;
        }
        for(int i=start; i<=5; i++){
            list.add(i);
            calSearch(i+1,count+1,m);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        int n=5;
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++)
            arr[i]=i;
        list = new ArrayList<>();
        //for(int i=1;i<3;i++){
        calSearch(1,0,3);
        //}
    }
}
