package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1
6 0
1 1 9 1 1 1
 */
/*
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1
 */
public class 프린터큐_1966{

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i <  n;i++){
            Queue<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(input.readLine());
            int arraySize = Integer.parseInt(st.nextToken());
            int searchIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(input.readLine());
            for(int j = 0;j < arraySize;j++)
                q.add(new int[]{j,Integer.parseInt(st.nextToken())});
            //System.out.println(q.peek()[0] + " " + q.peek()[1]);


            int count = 1;
            while(!q.isEmpty()){
                int[] currentData = q.poll();
                //가장 앞에 있는 q를 제거한 복제 생성
                Iterator<int[]> iterator = q.iterator();
                boolean checkPriority = false;

                //가장 앞에서 제거한 element를 남은 큐의 요소들과 비교해서 우선위가 더 큰 것이 있다면 루프 탈출
                while(iterator.hasNext()){
                    int[] compareData = iterator.next();
                    if(currentData[1] < compareData[1]){
                        checkPriority = true;
                        break;
                    }
                }
                if(checkPriority){ // 우선순위가 더 큰 것이 있었다면 큐에 재 삽입
                   q.add(currentData);
                }else{
                    if(currentData[0] == searchIndex) { //우선순위가 가장 높았고 목표 index와 같다면 현재까지 count 출력
                        System.out.println(count);
                        break;
                    }
                    else
                        count++;
                }
            }
        }
    }
}
