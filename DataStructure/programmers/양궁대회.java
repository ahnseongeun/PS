package DataStructure.programmers;

import java.util.Arrays;

/*
- 어피치 다 쏘고 라이언 다 쏜다 (n발 동일)
0점 부터 10점 까지 화살의 개수를 비교해서 점수를 가져가는 방식
단, 동일할 경우 어피치가 가져간다.

n 과 info가 주어진다.
1. 가장 큰 점수 차이로 우승하기 위해 n 발의 화살을 배열로 return
2. 지거나 비기는 경우 -1
3. 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.

문제 해결 과정
1. 가장 큰 차이로 이기는 방법
2. 그 차리중에 낮은 점수의 개수가 많은 것

높은 수는 무조건 1로 먹어야한다.
지는 수는 무조건 0로 먹어야한다.
남은 화살은 몰빵
=> 로직을 생각해서 풀려고 어려움
=> n이 10인 것을 발견해서 10!은 시간초과가 나지 않기 때문에 가능, 완전 탐색
매번 라이언의 총합과 어피치의 총합을 비교

작은 것 부터 완전 탐색하다가 발견하면 끝!

 */
public class 양궁대회 {

    static int n = 5;
    static int[] info = {2,1,1,1,0,0,0,0,0,0,0};
    static int[] arr = new int[11];

    public static void main(String[] args) {

        // 초기 값은 0,0,0,0,0,0,0,0,0,0,5 => 가장 작은 수
        arr[10] = n;
        int sum = 0;

        bfs(10);
    }

    private static void bfs(int idx) {
        if (idx == -1) return;

        for ( int i = 1; i < 11; i++) {
            bfs(idx - i);
        }
    }
}
