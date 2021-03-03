package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.

1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

N극은 0, S극은 1
방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향, 0 은 제자리

10101111
01111101
11001110
00000010
2
3 -1
1 1

7
 */
public class 톱니바퀴_14891 {

    private static char[] wheel1;
    private static char[] wheel2;
    private static char[] wheel3;
    private static char[] wheel4;
    private static boolean visited[];

    private static void moveWheel(int wheelNum, int direction) {

        int left = wheelNum - 1;
        int leftDirection = 0;
        int right = wheelNum + 1;
        int rightDirection = 0;
        visited[wheelNum] = true;

        if(wheelNum == 0){
            if(direction == 1){ //시계 방향
                rightDirection = wheel1[2] == wheel2[6] ? 0 : -1;
                for(int i = 0; i < 8; i++){
                    wheel1[(i + 1) % 8] = wheel1[i];
                }
            }else if(direction == 0){

            }else{ //반시계 방향
                rightDirection = wheel1[2] == wheel2[6] ? 0 : 1;
                for(int i = 0; i < 8; i++){
                    wheel1[(i - 1 + 8) % 8] = wheel1[i];
                }
            }
        }

        if(wheelNum == 1){
            if(direction == 1){ //시계 방향
                rightDirection = wheel2[2] == wheel3[6] ? 0 : -1;
                leftDirection = wheel1[2] == wheel2[6] ? 0 : -1;
                for(int i = 0; i < 8; i++){
                    wheel2[(i + 1) % 8] = wheel2[i];
                }
            }else if(direction == 0){

            }else{ //반시계 방향
                rightDirection = wheel2[2] == wheel3[6] ? 0 : 1;
                leftDirection = wheel1[2] == wheel2[6] ? 0 : 1;
                for(int i = 0; i < 8; i++){
                    wheel2[(i - 1 + 8) % 8] = wheel2[i];
                }
            }
        }

        if(wheelNum == 2){
            if(direction == 1){ //시계 방향
                rightDirection = wheel3[2] == wheel4[6] ? 0 : -1;
                leftDirection = wheel2[2] == wheel3[6] ? 0 : -1;
                for(int i = 0; i < 8; i++){
                    wheel3[(i + 1) % 8] = wheel3[i];
                }
            }else if(direction == 0){

            }else{ //반시계 방향
                rightDirection = wheel3[2] == wheel4[6] ? 0 : 1;
                leftDirection = wheel2[2] == wheel3[6] ? 0 : 1;
                for(int i = 0; i < 8; i++){
                    wheel3[(i - 1 + 8) % 8] = wheel3[i];
                }
            }
        }

        if(wheelNum == 3){
            if(direction == 1){ //시계 방향
                leftDirection = wheel3[2] == wheel4[6] ? 0 : -1;
                System.out.println("test");
                for(int i = 0; i < 8; i++){
                    wheel4[(i + 1) % 8] = wheel4[i];
                }
            }else if(direction == 0){

            }else{ //반시계 방향
                leftDirection = wheel3[2] == wheel4[6] ? 0 : 1;
                for(int i = 0; i < 8; i++){
                    wheel4[(i - 1 + 8) % 8] = wheel4[i];
                }
            }
        }

        display(wheel1);
        display(wheel2);
        display(wheel3);
        display(wheel4);

        if(left >= 0 && !visited[left])
            moveWheel(left,leftDirection);
        if(right <= 3 && !visited[right])
            moveWheel(right,rightDirection);
    }

    private static void display(char[] wheel) {
        StringBuilder sb = new StringBuilder();
        for(char ch : wheel)
            sb.append(ch);
        System.out.println(sb);
    }

    private static int calculationWheel() {
        int result = 0;
        result += wheel1[0] == 0 ? 0: 1;
        result += wheel2[0] == 0 ? 0: 2;
        result += wheel3[0] == 0 ? 0: 4;
        result += wheel4[0] == 0 ? 0: 8;
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        wheel1 = input.readLine().toCharArray();
        wheel2 = input.readLine().toCharArray();
        wheel3 = input.readLine().toCharArray();
        wheel4 = input.readLine().toCharArray();

        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            moveWheel(wheelNum - 1,direction);
        }
        System.out.println(calculationWheel());
    }
}
