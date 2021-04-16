package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터
오른쪽으로 방향
왼쪽방향으로으로 발사, 가장 먼저 만나는 단 하나의 탑에서만 수신
6 9 5 7 4 다섯 개의 탑이 수평 직선에 일렬
탑들의 높이는 1이상 100,000,000 (1억) 이하의 정수
N은 최대 5십만
5
6 9 5 7 4
stack에 넣고
최대 50만 * 50만
완전탐색으로 풀면 시간 초과 그러면 어떻게 접근 해야할까?
스택안에는 내림차순으로만 남게 한다. 그러면 새로 들어온 값을 검사하고
값 + 해당 값의 인덱스를 넣어준다.
            5
            6 9 5 7 4
 */
public class 탑_2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        Stack<int[]> stack = new Stack<>(); //위치, 값

        /*
        5
        6 9 5 7 4
         */
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());

            //내림차순으로만 정렬하면 되기 때문에 새로 들어온 값이 더 클경우 pop 진행
            while(!stack.isEmpty() && stack.peek()[1] < val){
                stack.pop();
            }

            //스택이 비었다면 제일 큰 수여서 0
            if(stack.isEmpty()){
                sb.append(0 + " ");
            }else{ //스택이 비지 않았다면 peek을 통해서 스택 최상단 값 넣기
                sb.append(stack.peek()[0]).append(" ");
            }
            //stack에 push
            stack.push(new int[]{i + 1, val});
        }
        System.out.println(sb);
    }
}

/*
int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
            stack.add(Integer.parseInt(st.nextToken()));

        if(stack.size() == 1)
            sb.append(0);
        else{
            int init = n - 2;
            while(!stack.isEmpty()){
                int value = stack.pop();
                int idx = init--;
                while(idx >= 0 && value > stack.get(idx)){
                    idx--;
                }
                if(idx == -1)
                    sb.insert(0,0+" ");
                else
                    sb.insert(0,idx + 1 + " ");
            }
        }
        System.out.println(sb);
 */
