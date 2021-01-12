package CodingTest.타다;

import java.util.ArrayList;
import java.util.Arrays;

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

        display(tags);

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
            display(tags);
        }
        display(tags);
        Arrays.sort(tags);

        ArrayList<Integer> counts = new ArrayList<>();
        int tmp = 1;
        for (int i = 1; i <= n - 1; i++) {
            if (tags[i] != tags[i + 1]) {
                counts.add(tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        counts.add(tmp);

        int answer = 0;
        for (int i = 0; i < counts.size() - 1; i++) {
            for (int j = i + 1; j < counts.size(); j++) {
                answer += counts.get(i)* counts.get(j);
            }
        }

        return answer;
    }
}
