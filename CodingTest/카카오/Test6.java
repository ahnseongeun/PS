package CodingTest.카카오;

public class Test6 {
    public static void main(String[] args) {

        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        for(int i = 0; i < skill.length; i++) {
            int[] skills = skill[i];
            int type = skills[0];
            int r1 = skills[1];
            int c1 = skills[2];
            int r2 = skills[3];
            int c2 = skills[4];
            int degree = skills[5];
            if(type == 1) {
                for(int j = r1; j <= r2 ; j++) {
                    for(int k = c1; k <= c2; k++) {
                        board[j][k] -= degree;
                    }
                }
            } else {
                for(int j = r1; j <= r2 ; j++) {
                    for(int k = c1; k <= c2; k++) {
                        board[j][k] += degree;
                    }
                }
            }
        }

        int n = board.length;
        int m = board[0].length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] > 0) result++;
            }
        }

        System.out.println(result);

    }
}
