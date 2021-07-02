package DataStructure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

 */

public class 이진검색트리_5639 {
    private static StringBuilder sb;
    private static void preOrder(Node node) {

        if(node == null) return;
        //left
        preOrder(node.left);
        //right
        preOrder(node.right);

        System.out.println(node.value);
    }

    private static Node insert(Node node, int val) {

        if(node == null) {
            node = new Node(val);
        } else if (val < node.value) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int root_value = Integer.parseInt(input.readLine());
        Node root = new Node(root_value);
        //트리 만들기
        String str = null;
        while((str = input.readLine()) != null){
            int n = Integer.parseInt(str);
            insert(root,n);
        }

        preOrder(root);

    }

    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
