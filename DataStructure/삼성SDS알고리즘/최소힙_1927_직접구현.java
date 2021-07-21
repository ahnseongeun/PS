package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class 최소힙_1927_직접구현 {

    private static void addOfTree(List<Integer> minHeap, int num) {

        //힙에 데이터를 더한다.
        minHeap.add(num);

        //인덱스 정보
        int current = minHeap.size() - 1;
        int parent = current / 2;

        //current가 root가 아니고 parent의 값이 더크다면 스왑 진행
        while(1 < current && minHeap.get(current) < minHeap.get(parent)) {

            //스왑
            int temp = minHeap.get(parent);
            minHeap.set(parent, minHeap.get(current));
            minHeap.set(current, temp);

            current = parent;
            parent = current / 2;

        }


    }

    private static int removeOfTree(List<Integer> minHeap) {

        if(minHeap.size() == 1) return 0;

        //root 선택
        int root = minHeap.get(1);

        //root를 가장 마지막 노드로 선택
        minHeap.set(1, minHeap.get(minHeap.size() - 1));
        //가장 마지막 노드 제거
        minHeap.remove(minHeap.size() - 1);

        //현재 위치는 1
        int currentPos = 1;

        while( true ) {

            //왼쪽 자식노드는 * 2
            int leftPos = currentPos * 2;
            //오른쪽 자식노드는 * 2
            int rightPos = currentPos * 2 + 1;

            //왼쪽 자식의 index가 최대 크기이상이면 break;
            if(leftPos >= minHeap.size()) break;

            //현재 최소의 값은 왼쪽 노드의 값
            int minValue = minHeap.get(leftPos);
            //현재 왼쪽 노드의 인덱스
            int minPos = leftPos;


            //오른쪽 값과 비교해서 왼쪽이 더크다면 오른쪽으로 교체
            if(rightPos < minHeap.size() && minValue > minHeap.get(rightPos)) {
                minValue = minHeap.get(rightPos);
                minPos = rightPos;
            }

            //현재 부모 노드와 선택된 자식노드와 교체체
           if(minHeap.get(currentPos) > minValue) {
                int temp = minHeap.get(currentPos);
                minHeap.set(currentPos, minHeap.get(minPos));
                minHeap.set(minPos, temp);
                currentPos = minPos;
            } else {
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> minHeap = new ArrayList<>();
        minHeap.add(0);
        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(input.readLine());
            if(num == 0) {
                sb.append(removeOfTree(minHeap)).append("\n");
            } else {
                addOfTree(minHeap, num);
            }
        }

        System.out.println(sb);
    }
}
