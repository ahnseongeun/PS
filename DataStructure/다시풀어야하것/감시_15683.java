//package DataStructure.다시풀어야하것;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//import java.util.stream.Collectors;
//
///**
// * #의 개수가 많을수록 사각지대는 최소이다.
// * CCTV의 경우의 수 4 ^ 8
// * 각 경우의 수마다 사각지대 계산 8 * 8
// * 90000 * 8 * 8
// */
//public class 감시_15683 {
//
////    private static StringBuilder sb = new StringBuilder();
//    private static int n;
//    private static int m;
//    private static int arr[][];
//    private static LinkedList<int[]> cctv;
//    private static int per[];
//    private static boolean visited[][];
//    private static int dx[] = {0,0,-1,1}; //상하좌우
//    private static int dy[] = {-1,1,0,0};
//    /**
//     * System.out.println(cctv.stream()
//     *                 .map(ints -> ints[0] + " " + ints[1] + " " + ints[2] + "\n")
//     *                 .collect(Collectors.joining()));
//     * @param idx
//     * @param count
//     */
//    // 상하좌우
//    private static int permutation(int idx, int count) { ;
//
//        if(idx == count){
//
//            visited = new boolean[n][m];
//            for(int i = 0 ; i < count; i++){
//                int[] tmp = cctv.get(i);
//                int y = tmp[0];
//                int x = tmp[1];
//                int cctvNumber = tmp[2];
//
//                visited[y][x] = true;
//
//                if(cctvNumber == 5){
//                    while(y >= 0){ //상
//                        y = y + dy[0];
//                        visited[y][x] = true;
//                    }
//                    while(y < n){ //하
//                        y = y + dy[1];
//                        visited[y][x] = true;
//                    }
//                    while(x >= 0){ //좌
//                        x = x + dx[2];
//                        visited[y][x] = true;
//                    }
//                    while(x < m){ //우
//                        x = x + dx[3];
//                        visited[y][x] = true;
//                    }
//                }else{
//                    int dir = per[i]; // 1 2 3 4 , 상 하 좌 우
//                    if(dir == 1){ // 상
//
//                    }else if(dir == 2){ // 하
//
//                    }else if(dir == 3){ // 좌
//
//                    }else{ // 우
//
//                    }
//
//                }
//            }
//            return result;
//        }
//
//        for(int i = 0; i < 4; i++){
//            per[idx] = i + 1;
//            permutation(idx + 1, count);
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception{
//
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(input.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        arr = new int[n][m];
//        cctv = new LinkedList<>();
//        int count = 0;
//
//        for(int i = 0; i < n; i++) {
//            st = new StringTokenizer(input.readLine());
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
//                    cctv.add(new int[]{i, j, arr[i][j]});
//                    count++;
//                }
//            }
//        }
//
//        per = new int[count];
//        permutation(0, count);
//
//    }
//}
