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
 * 상어가 벽에 도착하면 반대 방향으로 이동한다.
 */
public class 낚시 {

    static int n, m, t;
    static ArrayList<int[]> list;
    static HashMap<Integer, int[]> map = new HashMap<>();
    static int[][] check1;
    static int[][] check2;
    static int result = 0;

    static void removeShark(int idx) {

        int y = n;
        int removeIdx = -1;
        for(int key : map.keySet()) {
            int[] shark = map.get(key);
            int r = shark[0];
            int c = shark[1];
            if(c == idx && y >= r) {
                y = r;
                removeIdx = key;
            }
        }

        if(removeIdx != -1) {
            int[] removeShark = map.remove(removeIdx);
            //System.out.println(removeShark[0] + " " + removeShark[1]);
            result += removeShark[4];
        }

    }

    private static void moveShark() {

        HashMap<Integer,int[]> temp = new HashMap<>();
        check1 = new int[n + 1][m + 1];
        check2 = new int[n + 1][m + 1];
        //무게로 정렬한다.
        Set<Integer> set = new HashSet<>();
        //이동시킨다. 이미 check에 포함되어 있으면 삭제.
        for(int key : map.keySet()) {
            int[] shark = map.get(key);
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
            //check1 은 무게, check2는 Hash번호
            if(check1[r][c] < z) {
                temp.put(z, new int[]{r, c, s, d, z});
                check1[r][c] = z;
            }
        }

        map.clear();
        map.putAll(temp);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        //list = new ArrayList<>();

        //상어 데이터 저장
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            //크기 순으로 정렬
            //list.add(new int[]{r, c, s, d, z});
            map.put(z, new int[]{r, c, s, d, z});
        }

        //list.sort((o1, o2) -> o2[4] - o1[4]);
        for(int i = 1; i <= m; i++) {
            removeShark(i);
            moveShark();
        }

        System.out.println(result);
    }
}
