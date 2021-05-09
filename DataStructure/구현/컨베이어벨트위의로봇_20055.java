package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
컨베이어 벨트를 이용해 로봇들을 건너편으로 옮기려고 한다. 로봇을 옮기는 과정에서는 아래와 같은 일이 순서대로 일어난다.

1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다. 내리는 위치에 있는 로봇은 내린다.
2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
2 - 1 로봇이 이동하기 위해서는 로봇이 내리는 위치가 아니고, 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
종료되었을 때 몇 번째 단계가 진행 중이었는지 구해보자. 가장 처음 수행되는 단계는 1번째 단계이다.
3 2
1 2 1 2 1 2
 */
public class 컨베이어벨트위의로봇_20055 {
    private static int[] convey;
    private static boolean[] robots;
    private static int n, k;
    private static int cnt = 0;

    private static void setFirst() {

        //한칸전진은 어떻게??
        int pre_temp = convey[0];
        for(int i = 1; i <= convey.length; i++){
            int temp = convey[i % convey.length];
            convey[i % convey.length] = pre_temp;
            pre_temp = temp;
        }

        for(int i = robots.length - 1; i > 0; i--){
            robots[i] = robots[i - 1];
        }
        robots[0] = false;



        if(robots[n - 1])
            robots[n - 1] = false;

    }

    private static void setSecond() {
        for(int i = n - 2; i >= 0 ;i--){
            if(robots[i] && !robots[i + 1] && convey[i + 1] > 0){ //true라면 로봇이 존재한다.
                robots[i] = false;
                robots[i + 1] = true;
                convey[i + 1]--;
            }
        }
    }

    private static void setThird() {
        if(convey[0] == 0)
            return;
        convey[0]--;
        robots[0] = true;
    }

    private static boolean setForth() {
        int result = (int) Arrays.stream(convey).filter(value -> value == 0).count();
        if(k <= result)
            return true;
        return false;
    }

    private static int getTime() {

        int time  = 1;

        while(true) {
            setFirst();
            setSecond();
            setThird();
            if (setForth())
                break;
            time++;
        }
        return time;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken()); // n은 총 컨테이너의 개수
        k = Integer.parseInt(st.nextToken()); // k 는 0인 칸의 개수
        st = new StringTokenizer(input.readLine());

        convey = new int[2 * n];
        robots = new boolean[n];
        for(int i = 0; i < 2 * n; i++)
            convey[i] = Integer.parseInt(st.nextToken());
        System.out.println(getTime());
    }

}
