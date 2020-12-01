package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface CustomQueue{
    void push(int data);
    int pop();
    int size();
    int empty();
    int front();
    int back();

}

class MyQueue implements CustomQueue {
    private int front;
    private int rear;
    private int[] array;
    private int data;

    MyQueue(){
        this.front=0;
        this.rear=0;
        this.array=new int[2000001];
    }
    @Override
    public void push(int data) {
            array[rear++]=data;
    }

    @Override
    public int pop() {
        return rear==front?-1:array[front++];
    }

    @Override
    public int size() {
        return rear-front;
    }

    @Override
    public int empty() {

        return (rear-front)==0?1:0;
    }

    @Override
    public int front() {
        if(empty()==1){
            return -1;
        }else{
            return array[front];
        }
    }

    @Override
    public int back() {
        if(empty()==1){
            return -1;
        }else{
            return array[rear-1];
        }
    }
}

public class 백준_18258_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(input.readLine());
        MyQueue q=new MyQueue();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            String command= st.nextToken();
            if(command.equals("push")){
                int data=Integer.parseInt(st.nextToken());
                q.push(data);
            }else if(command.equals("pop")){
                sb.append(q.pop()+"\n");
            }else if(command.equals("size")){
                sb.append(q.size()+"\n");
            }else if(command.equals("empty")){
                sb.append(q.empty()+"\n");
            }else if(command.equals("front")){
                sb.append(q.front()+"\n");
            }else{//back
                sb.append(q.back()+"\n");
            }
        }
        System.out.println(sb);
    }
}
