package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
3
FFLF
FFRRFF
FFFBBBRFFFBBB
 */
public class 거북이_8911 {


    private static Stack<int[]> stack;
    private static int dx[] ={0,1,0,-1}; //0 북, 1 동, 2 남, 3 서
    private static int dy[] ={-1,0,1,0};
    private static int calSquare(String command) {
        int x = 0;
        int y = 0;
        int d = 0;
        stack.add(new int[]{x,y,d});
        for(int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);
            int[] location = stack.peek();
            x = location[0];
            y = location[1];
            d = location[2];
            if(ch == 'F'){ //한칸 전진
                x = x + dx[d];
                y = y + dy[d];
                stack.add(new int[]{x,y,d});
            }else if(ch == 'B'){ //한칸 후진
                x = x - dx[d];
                y = y - dy[d];
                stack.add(new int[]{x,y,d});
            }else if(ch == 'R'){ //오른쪽 90도 회전
                stack.add(new int[]{x,y,(d + 1) % 4});
            }else{ //왼쪽 90도 회전
                stack.add(new int[]{x,y,(d + 3) % 4});
            }
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            int[] location = stack.pop();
            minX = Math.min(minX,location[0]);
            minY = Math.min(minY,location[1]);
            maxX = Math.max(maxX,location[0]);
            maxY = Math.max(maxY,location[1]);
        }
        return (maxY - minY) * (maxX - minX);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            stack = new Stack<>();
            String command = input.readLine();
            sb.append(calSquare(command) + "\n");
        }
        System.out.println(sb);
    }
}
