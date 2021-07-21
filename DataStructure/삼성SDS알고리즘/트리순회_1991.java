package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */

/**
 * mid를 기준으로 정한다
 * post는 mid -> left -> right
 * in은 left -> mid -> right
 * pre은 left -> right -> mid
 */
public class 트리순회_1991 {

    static HashMap<Character, char[]> tree;
    static StringBuilder sb;

    // mid -> left -> right
    private static void postOrder(char node) {

        char leftNode = tree.get(node)[0];
        char rightNode = tree.get(node)[1];
        sb.append(node);
        if(leftNode != '.')
            postOrder(leftNode);
        if(rightNode != '.')
            postOrder(rightNode);
    }

    //left -> mid -> right
    private static void inOrder(char node) {

        char leftNode = tree.get(node)[0];
        char rightNode = tree.get(node)[1];

        if(leftNode != '.')
            inOrder(leftNode);
        sb.append(node);
        if(rightNode != '.')
            inOrder(rightNode);
    }

    //left -> right -> mid
    private static void preOrder(char node) {

        char leftNode = tree.get(node)[0];
        char rightNode = tree.get(node)[1];
        if(leftNode != '.')
            preOrder(leftNode);
        if(rightNode != '.')
            preOrder(rightNode);
        sb.append(node);
    }



    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        tree = new HashMap<>();
        sb = new StringBuilder();
        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            char root = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);
            tree.put(root, new char[]{leftNode, rightNode});
        }

        postOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        preOrder('A');
        System.out.println(sb);
    }
}
