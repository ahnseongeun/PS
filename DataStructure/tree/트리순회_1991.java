package DataStructure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
public class 트리순회_1991 {

    static StringBuilder sb = new StringBuilder();
    static int[][] binaryTree;
    static boolean check[];
    private static void postOrder(int idx) {

        sb.append((char)(idx + 'A'));
        //left
        if(binaryTree[idx][0] != -1) postOrder(binaryTree[idx][0]);
        //right
        if(binaryTree[idx][1] != -1) postOrder(binaryTree[idx][1]);
    }

    private static void inOrder(int idx) {

        //left
        if(binaryTree[idx][0] != -1) inOrder(binaryTree[idx][0]);

        sb.append((char)(idx + 'A'));

        //right
        if(binaryTree[idx][1] != -1) inOrder(binaryTree[idx][1]);

    }

    private static void preOrder(int idx) {

        //left
        if(binaryTree[idx][0] != -1) preOrder(binaryTree[idx][0]);

        //right
        if(binaryTree[idx][1] != -1) preOrder(binaryTree[idx][1]);

        sb.append((char)(idx + 'A'));

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        binaryTree = new int[27][2];
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            int rootIdx = root - 'A';
            //left
            binaryTree[rootIdx][0] = left == '.' ? -1 : left - 'A';
            //right
            binaryTree[rootIdx][1] = right == '.' ? -1 : right - 'A';
        }

        //전위 순회
        postOrder(0);
        sb.append("\n");
        //중위 순회
        inOrder(0);
        sb.append("\n");
        //후회 순회
        preOrder(0);
        System.out.println(sb);
    }
}
