package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    private int array_size;
    private int data;

    MyQueue(){
        this.front=0;
        this.rear=0;
        this.array=new int[3];
        this.array_size=array.length;
        Arrays.fill(array,-1);
    }
    @Override
    public void push(int data) {
        if(rear==array_size)
            rear=0;
        if(array[rear]==-1){
            array[rear]=data;
            rear++;
        }else{
            System.out.println("큐가 가득 찾습니다.");
        }
    }

    @Override
    public int pop() {
        if(front==array_size)
            front=0;
        if(rear==front&&array[(front+1)%array_size]==-1){ //마지막에서 오류 났을 경우 해결하기
            return -1;
        }else{
            int temp=array[front];
            array[front]=-1;
            front++;
            return temp;
        }
    }

    @Override
    public int size() {
        int count= (int) Arrays.stream(array).filter(num -> num!=-1).count();
        return count;
    }

    @Override
    public int empty() {

        return size()==0?1:0;
    }

    @Override
    public int front() {
        if(empty()==1){
            return -1;
        }else{
            if(front==array_size)
                front=0;
            return array[front];
        }
    }

    @Override
    public int back() {
        if(empty()==1){
            return -1;
        }else{
            if(rear==0)
                return array[array_size-1];
            else
                return array[rear-1];
        }
    }
    public void display(){
        StringBuilder sb=new StringBuilder();
        for(int a:array)
            sb.append(a+" ");
        System.out.println(sb);
    }
}

public class 백준_18258_큐_원형배열사용 {
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
                //sb.append(q.pop()+"\n");
                System.out.println(q.pop());
            }else if(command.equals("size")){
                sb.append(q.size()+"\n");
                System.out.println(q.size());
            }else if(command.equals("empty")){
                sb.append(q.empty()+"\n");
                System.out.println(q.empty());
            }else if(command.equals("front")){
                sb.append(q.front()+"\n");
                System.out.println(q.front());
            }else{//back
                sb.append(q.back()+"\n");
                System.out.println(q.back());
            }
            q.display();
        }
        System.out.println(sb);
    }
}
