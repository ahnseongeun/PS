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

    Node(int data){
        this.data = data;
        this.next = null;
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
             * 2. 새로운 노드의 다음 노드를 head를 가르킨다.
             * 3. 새로운 노드로 head를 옮긴다.
             * 4. 리스트의 크기를 1 증가 시킨다.
             * 5. head의 다음 비었다면 tail == head 이다.
             */
            if(command.equals("push_front")){
                int data = Integer.parseInt(st.nextToken());
                Node node = new Node(data);
                node.next = head;
                head = node;

                size++;

                if(head.next == null)
                    tail = head;
            }

            /**
             * push_back는 가장 뒤에 원소를 추가하는 것이다.
             * 1. 새로운 노드를 만든다
             * 2. 리스트가 비어었으면 새로운 노드로 head를 옮긴다.
             * 3. tail의 next에 새로운 노드를 삽입한다.
             * 4. 새로운 노드로 tail을 옮긴다.
             * 5. 리스트의 크기를 1 증가 시킨다.
             */
            if(command.equals("push_back")){
                int data = Integer.parseInt(st.nextToken());
                Node node = new Node(data);
                if(size == 0) {
                    head = node;
                }else{
                    tail.next = node;
                }
                tail = node;
                size++;
            }

            /**
             * pop_front는 가장 앞에 원소를 빼내는 것이다.
             * 1.head를 head.next로 만 옮긴다.
             */
            if(command.equals("pop_front")){
                if(head == null) {
                    sb.append("-1\n");
                    System.out.println(sb);
                    continue;
                }
                sb.append(head.data).append("\n");
                head = head.next;
                size --;
            }

            /**
             * pop_back는 가장 뒤에 원소를 빼내는 것이다.
             * size를 이용해서 원소를 순차적으로
             */
            if(command.equals("pop_back")){
                if(size == 0){
                    sb.append("-1\n");
                    System.out.println(sb);
                    continue;
                }else{
                    Node node = head;
                    System.out.println(tail.data);
                    while(node != null){
                        if(node.next == tail){
                            System.out.println("tset1");
                            sb.append(node.data).append("\n");
                            node = tail;
                        }
                        node = node.next;
                    }
                    size--;
                }
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
                sb.append(size == 0 ? 1 : 0 + "\n");
            }

            /**
             * push_front는 가장 앞에 원소를 추가하는 것이다.
             * 1. 새로운 노드를 만든다
             * 2. 새로운 노드의 다음 노드를 head를 가르킨다.
             * 3. 새로운 노드로 head를 옮긴다.
             */
            if(command.equals("front")){

            }

            /**
             * push_front는 가장 앞에 원소를 추가하는 것이다.
             * 1. 새로운 노드를 만든다
             * 2. 새로운 노드의 다음 노드를 head를 가르킨다.
             * 3. 새로운 노드로 head를 옮긴다.
             */
            if(command.equals("back")){ //back

            }
            display(head);
            System.out.println("size: "+size);
            System.out.println("result: "+sb);
        }
    }
}
