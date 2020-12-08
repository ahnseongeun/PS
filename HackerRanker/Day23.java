package HackerRanker;

import java.util.*;
import java.io.*;
class Node2{
    Node2 left,right;
    int data;
    Node2(int data){
        this.data=data;
        left=right=null;
    }
}
public class Day23{
    static  StringBuilder sb=new StringBuilder();
    static Queue<Node2> q=new LinkedList<>();
    static void levelOrder(Node2 root){
        //Write your code here
        q.add(root);
        while(!q.isEmpty()){
            Node2 newNode= q.poll();
            sb.append(newNode.data+" ");
            if(newNode.left!=null)
                q.add(newNode.left);
            if(newNode.right!=null)
                q.add(newNode.right);
        }
        System.out.println(sb);
    }

    public static Node2 insert(Node2 root,int data){
        if(root==null){
            return new Node2(data);
        }
        else{
            Node2 cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node2 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}
