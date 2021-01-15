package 이것이코딩테스트다_BOOK.구현;

/*
어려워서
일단은 순열과 완전탐색부터 밀고다시 풀러오자.
 */

import java.util.*;
/*
n	weak	        dist	        result
12	[1, 5, 6, 10]	[1, 2, 3, 4]	2
 */
class 외벽점검 {
    static int[] wall;
    static boolean check[];
    static int result=0;

    private void displayWall(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<check.length;i++){
            sb.append(check[i]+" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
    private void searchWall(int n,int[] dist,int [] weak){
        int min=Integer.MAX_VALUE;
        // 거리 벽 기준?
        for(int i = dist.length-1; i >= 0; i--){ //거리를 구한다.
            int distance = dist[i];
            System.out.println("distance: "+ distance);
            result+=1;
            int cnt = -1;
            for(int j = 0; j < weak.length; j++) { //weak마다 출발
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int idx = weak[j];

                for (int r = 1; r <= distance; r++) { //시계 방향
                    int weakWall = wall[((idx + r + n) % n)];
                    boolean checkWall = check[((idx + r + n) % n)];
                    if (weakWall == 1 && !checkWall) { //weak이고 방문되지 않았때 count
                        cnt1++;
                    }
                }

                for (int l = 1; l <= distance; l++) { //반시계 방향
                    int weakWall = wall[((idx - l + n) % n)];
                    boolean checkWall = check[((idx - l + n) % n)];
                    if (weakWall == 1 && !checkWall) { //weak이고 방문되지 않았때 count
                        cnt2++;
                    }
                }

            }
//                if(cnt1>cnt2){
//                    for(int r = 1; r <= distance ; r++){ //시계 방향
//                        int weakWall = wall[((idx + r + n) % n)];
//                        boolean checkWall = check[((idx + r + n) % n)];
//                        if(weakWall == 1 && !checkWall){ //weak이고 방문되지 않았때 count
//                            check[((idx + r + n) % n)] = true;
//                        }
//                    }
//                }else{
//                    for(int l = 1; l <= distance ; l++){ //반시계 방향
//                        int weakWall = wall[((idx - l + n) % n)];
//                        boolean checkWall = check[((idx - l + n) % n)];
//                        if(weakWall == 1 && !checkWall){ //weak이고 방문되지 않았때 count
//                            check[((idx + l + n) % n)] = true;
//                        }
//                    }
//                }


            int count = 0;
            displayWall();
            for(int j = 0;j < weak.length ;j++){
                if(!check[weak[j]])
                    break;
                count++;
                if(count==weak.length-1)
                    return;
            }
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        wall = new int[n+1];
        check = new boolean[n+1];

        for(int i = 0;i < weak.length; i++)
            wall[weak[i]] = 1;

        searchWall(n,dist,weak);
        int answer = result;
        return answer;
    }
}
