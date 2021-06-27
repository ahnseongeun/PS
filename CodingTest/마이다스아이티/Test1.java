package CodingTest.마이다스아이티;

public class Test1 {

    private static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    private static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[][] solution(int n, int[][] mine) {
        int[][] answer = new int[n][n];
        for(int i = 0; i < mine.length; i++){
            int[] location = mine[i];
            answer[location[0] - 1][location[1] - 1] = -1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(answer[i][j] == -1) continue;
                for(int k = 0; k < 8; k++){
                    int next_y = i + dy[k];
                    int next_x = j + dx[k];
                    if(next_y < 0 || next_x < 0 || next_y >= n || next_x >= n) continue;
                    if(answer[next_y][next_x] == -1) answer[i][j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] arr = { {1, 1}, {1, 7}, {2, 7}, {3, 6}, {4, 1}, {4, 4}, {4, 8}, {8, 4}, {8, 5}, {9, 6}};
        int[][] result = solution(n, arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
