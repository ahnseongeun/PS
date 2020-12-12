package HackerRanker.Day24;
import java.io.*;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}
public class Day24
{

    public static Node removeDuplicates(Node head) {
        //Write your code here
        if(head==null){
            return head;
        }else{
            Node start=head;
            while(start.next!=null){
                Node start_next=start.next;
                //다음 노드와 값이 같다면 다음노드의 next를 현재노드의 next로
                if(start_next.data==start.data) {
                    start.next = start_next.next;
                }
                else{ //다음 노드와 같지않다면 start를 다음 노드로
                    start=start_next;
                }
            }
        }
        return head;
    }

    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
    {
        Node start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}