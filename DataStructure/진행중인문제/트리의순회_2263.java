package DataStructure.진행중인문제;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
pre root -> left -> right
in left -> root -> right
post left -> right -> root
3
1 2 3
1 3 2
 */
public class 트리의순회_2263 {

    private static int[] inOrder;
    private static int[] postOrder;
    //rootIdx를 기준으로 left의 수와 right 수를 구하기 위한 변수 배열
    private static int[] inOrderRootIdx;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        inOrder = new int[n + 1];
        postOrder = new int[n + 1];
        inOrderRootIdx = new int[n + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= n; i++) inOrder[i] = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) inOrderRootIdx[inOrder[i]] = i;
        st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= n; i++) postOrder[i] = Integer.parseInt(st.nextToken());
        preOrder(1,n,1,n);
        System.out.println(sb);
    }

    private static void preOrder(int inOrderLeft, int inOrderRight, int postOrderLeft, int postOrderRight) {

        //left_idx가 right_idx보다 크다면 그만
        if(inOrderLeft > inOrderRight || postOrderLeft > postOrderRight) return;

        //root를 먼저 구하자. root는 postOrder의 제일 마지막 Index
        int root = postOrder[postOrderRight];
        sb.append(root).append(" ");

        //root의 index를 구하자.
        int rootIdx = inOrderRootIdx[root];

        //left의 개수를 count
        int leftCount = rootIdx - inOrderLeft;

        //left
        //inorder의 index는 left, rootIdx - 1
        //postOrder의 index는 left, left - 1 + leftCount
        preOrder(inOrderLeft,rootIdx - 1, postOrderLeft, postOrderLeft - 1 + leftCount);

        //right
        //inorder의 index는 rootIdx + 1, inorderright
        //postOrder의 index는 left + leftCount, postOrderRight
        preOrder(rootIdx + 1, inOrderRight, postOrderLeft + leftCount, postOrderRight - 1);
    }
}
