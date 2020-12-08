package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws  Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        sb.append('<');
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=n;i++)
            list.add(i);
        int start=1;
        int size=list.size();
        for(int i=1;i<=n;i++){
            start=(start+(k-1))%(size-i);
            if(start==0)
                start=list.size()-1;
            System.out.println(list);
            sb.append(list.remove(start)+", ");
        }
        System.out.println(sb.substring(0,sb.length()-2)+">");
        /*
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++)
            q.add(i);
        while(!q.isEmpty()){
            for(int i=0;i<k-1;i++){
                int temp=q.poll();
                q.add(temp);
            }
            int a=q.poll();
            if(q.isEmpty()){
                sb.append(a+">");
            }else{
                sb.append(a+", ");
            }
        }
         */
    }
}
