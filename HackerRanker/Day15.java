package HackerRanker;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day15 {
    public static  Node insert(Node head,int data) {
        //Complete this method
        Node node=new Node(data); //data를 담은 node 등록
        if(head==null){ //head가 아무것도 가르키고 있지 않다면 node를 head라고 임명
            head=node;
        }else{
            Node temp = head; //임시적인 node를 이용해서
            while(temp.next!=null){ //node가 next_node가 있다면 node를 next_node로 바꾼다.
                temp=temp.next;
            }
            //node_node가 없다는 것은 마지막 node이기 때문에 새로 생성된 node를 추가하고 head를 반환한다.
            temp.next=node;
        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}