package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합구하기_2042 {
    private static int s;
    private static int n;
    private static long[] tree;
    private static long[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        nums = new long[n];

        int s = 1;
        while(s < n) {
            s *= 2;
        }
        tree = new long[n * 2];


    }

    //bottom-up
    static void initBU() {

        //leaf에 값 반영
        for (int i = 0; i < n; i++) {
            tree[s + i] = nums[i];
        }

        // 내부노드 채우기
        for (int i = s - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        //연관이 없음 -> 결과에 영향이 없는 걸 return
        if(queryRight < left || right < queryLeft) {
            return 0;
        }

        // 판단 가능 -> 현재 노드 값 return
        else if(queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        //판단 불과, 자식에게 위임, 자식에서 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            //자식은 부모 * 2
            long leftResult = query(left, mid, node * 2, queryLeft, queryRight);
            long rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        //연관 없음
        if(target < left || right < target) {
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right ) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
