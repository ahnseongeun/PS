package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

class Node{
    int data;
    Node next;
    Node pre;

    Node(int data){
        this.data = data;
        this.next = null;
        this.pre = null;
    }
}

public class 덱_10866 {

    private static int size = 0;

    private static void display(Node head) {

        StringBuilder sb = new StringBuilder();
        Node node = head;
        while(node != null){
            sb.append(node.data);
            node = node.next;
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        Node head = null;
        Node tail = null;

        for(int i = 0;i < n; i++){
            StringTokenizer st= new StringTokenizer(input.readLine());
            String command = st.nextToken();

            /**
             * push_front는 가장 앞에 원소를 추가하는 것이다.
             * 1. 새로운 노드를 만든다
             * 2. head가 null 이라면 head와 tail 초기화
             * 3. head가 null이 아니라면 head.pre에 node 추가
             * 4. node.next를 head로
             * 5. head에 node 대입
             */
            if(command.equals("push_front")){
                int data = Integer.parseInt(st.nextToken());
                Node node = new Node(data);
                if(head == null) {
                    head = node;
                    tail = node;
                }else{
                    head.pre = node;
                    node.next = head;
                    head = node;
                }
                size++;
            }

            /**
             * push_back는 가장 뒤에 원소를 추가하는 것이다.
             * 1. 새로운 노드를 만든다
             * 2. tail이 null 이라면 head에 node 삽입
             * 3. tail이 null이 아니라면 tail.next에 node 삽입
             * 4. node.pre에 tail 삽입
             * 5. tail에 node 대입
             */
            if(command.equals("push_back")){
                int data = Integer.parseInt(st.nextToken());
                Node node = new Node(data);
                if(tail == null) {
                    head = node;
                }else{
                    tail.next = node;
                    node.pre = tail;
                }
                tail = node;
                size++;
            }

            /**
             * pop_front는 가장 앞에 원소를 빼내는 것이다.
             * 1. head가 null이면 -1 출력
             * 2. head.next가 null이면
             * 3. head.data 출력후 초기화
             * 4. head.next가 null이 아니면
             * 5. head.data 출력후 head에 head.next 대입
             * 6. head.pre에 null 추가
             */
            if(command.equals("pop_front")){
                if(head == null){
                    sb.append("-1\n");
                    continue;
                }
                if(head.next == null) {
                    sb.append(head.data).append("\n");
                    head = null;
                    tail = null;
                }else{
                    sb.append(head.data).append("\n");
                    head = head.next;
                    head.pre = null;
                }
                size --;
            }

            /**
             * pop_back는 가장 뒤에 원소를 빼내는 것이다.
             * 1. tail.pre가 null이라면 tail 데이터 출력후 초기화
             * 2. tail.pre가 null이 아니라면 tail 데이터 출력 후에 
             * 3. tail에 tail.pre 대입
             * 4. tail.next에 null 추가
             */
            if(command.equals("pop_back")){
                if(tail == null){
                    sb.append("-1\n");
                    continue;
                }
                if(tail.pre == null) {
                    sb.append(tail.data).append("\n");
                    head = null;
                    tail = null;
                }else {
                    sb.append(tail.data).append("\n");
                    tail = tail.pre;
                    tail.next = null;
                }
                size--;

            }

            /**
             * size는 현재 deque의 크기를 구한다.
             * 1. 내부적으로 size를 저장하면서 size만 반환하면 된다.
             */
            if(command.equals("size")){
                sb.append(size+"\n");
            }

            /**
             * empty는 비었는지 확인하는 것이다.
             * size가 0이면 empty
             */
            if(command.equals("empty")){
                sb.append(head == null ? 1 : 0).append("\n");
            }

            /**
             * front는 가장 앞에 원소를 확인하는 것
             * 1. head의 데이터를 출력한다.
             */
            if(command.equals("front")){
                if(size == 0){
                    sb.append("-1\n");
                }else{
                    sb.append(head.data+"\n");
                }
            }

            /**
             * back는 가장 뒤에 원소를 확인하는 것이다.
             * 1. back의 데이터를 출력한다.
             */
            if(command.equals("back")){ //back
                if(size == 0){
                    sb.append("-1\n");
                }else{
                    sb.append(tail.data+"\n");
                }
            }
            //display(head);
//            System.out.println("size: "+size);
//            System.out.println("result: "+sb);
        }
        System.out.println(sb);
    }
}
