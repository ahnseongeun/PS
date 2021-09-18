package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4 6 8
4 1 3 3 8
1 3 5 2 9
2 4 8 4 1
4 5 0 1 4
3 3 1 2 7
1 5 8 4 3
3 6 2 1 2
2 2 2 3 5
r,c 상어의 위치
s는 속력
d는 이동방향 , 위 1, 아래 2, 오른쪽 3, 왼쪽 4
z는 크기
 */

/**
 * 1. 이동 거리 줄이기
 * 2. list 대신 map 사용하기
 */
public class 낚시왕_17143 {

    static int n, m;
    static ArrayList<int[]> list;
    static int[][] check;
    static int result = 0;

    static void removeShark(int idx) {

        for(int i = 0; i < list.size(); i++) {
            int[] shark = list.get(i);
            int c = shark[1];
            if(c == idx) {
                result += list.remove(i)[4];
                break;
            }
        }

    }

    private static void moveShark() {

        //무게로 정렬한다.
        ArrayList<int[]> newList = new ArrayList<>();
        check = new int[n + 1][m + 1];
        //이동시킨다. 이미 check에 포함되어 있으면 삭제.
        for(int i = 0; i < list.size(); i++) {
            int[] shark = list.get(i);
            int r = shark[0];
            int c = shark[1];
            int s = shark[2];
            int d = shark[3];
            int z = shark[4];
            if( d == 1 || d == 2) {
                for(int j = 0; j < s; j++) {
                    if( d == 1 && r == 1) {
                        d = 2;
                    }
                    if( d == 2 && r == n) {
                        d = 1;
                    }
                    if(d == 1) r--;
                    if(d == 2) r++;
                }
            } else {
                for(int j = 0; j < s; j++) {

                    if( d == 3 && c == m) {
                        d = 4;
                    }
                    if( d == 4 && c == 1) {
                        d = 3;
                    }

                    if(d == 3) c++;
                    if(d == 4) c--;
                }
            }
            newList.add(new int[]{r,c,s,d,z});
        }
        list.clear();
        for(int[] shark : newList) {
            int r = shark[0];
            int c = shark[1];
            int s = shark[2];
            int d = shark[3];
            int z = shark[4];
            if(check[r][c] < z) {
                check[r][c] = z;
                list.add(new int[]{r, c, s, d, z});
            }
        }

//        StringBuilder sb = new StringBuilder();
//        for(int i = 1; i <= n; i++ ) {
//            for(int j = 1; j <= m; j++) {
//                sb.append(check[i][j]).append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        //상어 데이터 저장
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            //크기 순으로 정렬

            list.add(new int[]{r, c, s, d, z});
        }

        for(int i = 1; i <= m; i++) {
            list.sort((o1, o2) -> {
                if(o1[1] == o2[1]) {
                    if(o1[0] == o2[0]) return o2[4] - o1[4];
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });
            removeShark(i);
            moveShark();
        }

        System.out.println(result);
    }
}
