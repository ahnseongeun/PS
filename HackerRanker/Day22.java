package HackerRanker;

import java.util.Scanner;

class Node1{
    Node1 left,right;
    int data;
    Node1(int data){
        this.data=data;
        left=right=null;
    }
}

public class Day22 {

    public static int getHeight(Node1 root){
        //Write your code here
        if(root==null){
            return -1;
        }else{
            int left_h=getHeight(root.left);
            int right_h=getHeight(root.right);
            return 1+(left_h>right_h?left_h:right_h);
        }
        /*
        if(root.left==null&&root.right==null){
            return 0;
        }else if(root.left==null){
            return getHeight(root.right)+1;
        }else if(root.right==null){
            return getHeight(root.left)+1;
        }else{
            return getHeight(root.left)+getHeight(root.right);
        }
        */
    }
    public static int Node_count(Node1 root){
        if(root==null){
            return 0;
        }else{
            return Node_count(root.left)+Node_count(root.right)+1;
        }
    }
    public static Node1 insert(Node1 root,int data){
        if(root==null){
            return new Node1(data);
        }else{
            Node1 cur;
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

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node1 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        int count=Node_count(root);
        System.out.println(height);
        System.out.println(count);
    }
}
