package CodingTest.타다;

import java.util.ArrayList;
import java.util.Arrays;
/*
    private void display(int[] student) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< student.length;i++)
            sb.append(student[i]+" ");
        System.out.println(sb);
    }
 */
class Test1_2 {
    private void display(int[] student) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< student.length;i++)
            sb.append(student[i]+" ");
        System.out.println(sb);
    }
    int solution(int n, int[][] nationality) {

        int tags[]=new int[n+1];
        for (int i = 1; i <= n; i++) {
            tags[i] = i;
        }
        //ex: {{1,2},{1,4},{4,5},{6,8},{7,8},{1,7},{9,1},{10,11},{10,13},{20,17},{14,5},{17,18},{18,3}};
        /**
         * 순서쌍에서 오른쪽 값을 인덱스로 한 값과 비교해서 같으면 왼쪽 값을 인덱스로한 값으로 변경
         */
        for (int i = 0; i < nationality.length; i++) {
            int temp = tags[nationality[i][1]];
            //temp는 현재 입력받은 오른쪽 값을 인덱스로한 값
            for (int j = 1; j <= n; j++) {
                if (tags[j] == temp) {
                    //하나씩 검사하면서 오른쪽 값과 일치하면
                    tags[j] = tags[nationality[i][0]];
                    //왼쪽 값을 인덱스로 해서 해당 인덱스의 값으로 변경
                }
            }
        }
        Arrays.sort(tags);

        int sum=0;
        int total[]=new int[tags.length];

        for(int i=1;i< tags.length;i++){ //순서쌍 Count
            total[tags[i]]+=1;
        }
        display(total);

        for(int i=1;i< tags.length;i++){
            for(int j=i+1;j< tags.length;j++)
                if(total[i]==0||total[j]==0)
                    continue;
                else
                    sum+=(total[i]*total[j]); //모든 경우의 수 구하기
        }

        return sum;
    }
}
