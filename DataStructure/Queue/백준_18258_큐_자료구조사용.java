package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
사용된 메모리 349228KB
시간 1496ms
 */

public class 백준_18258_큐_자료구조사용 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(input.readLine());
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            String command= st.nextToken();
            if(command.equals("push")){
                int data=Integer.parseInt(st.nextToken());
                q.add(data);
            }else if(command.equals("pop")){
                sb.append((q.peek()==null?-1:q.poll())+"\n");
            }else if(command.equals("size")){
                sb.append((q.size()==0?0:q.size())+"\n");
            }else if(command.equals("empty")){
                sb.append((q.isEmpty()==true?1:0)+"\n");
            }else if(command.equals("front")){
                sb.append((q.peek()==null?-1:q.getFirst())+"\n");
            }else{//back
                sb.append((q.peek()==null?-1:q.getLast())+"\n");
            }
        }
        System.out.println(sb);
    }
}
