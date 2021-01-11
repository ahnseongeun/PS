package CodingTest.타다;

import java.util.HashMap;

/**
 * 문제 설명
 * 학생수가 n명인 어느 국제 학교에서 서로 다른 국적을 가진 학생 대표 두 명을 뽑으려 합니다.
 * 이 학교에서는 국적을 파악하기 위해 학생에게 1부터 n까지 중복없이 번호를 붙이고, 같은 국적을 가진 학생 쌍을 기록해 뒀습니다.
 * 이때, 대표 두 명을 뽑는 방법은 모두 몇 가지인지 구하려 합니다.
 * 단, 어떤 두 학생 A, B의 국적 관계가 기록에 없고, 다른 학생들의 관계를 이용해서도 알아낼 수 없는 경우 A, B 두 학생의 국적은 항상 다릅니다.
 * 예를 들어 학생 수가 4명이고, 기록 용지에 [1, 2], [2, 3], [1, 3] 이 적혀 있으면 4번 학생을 제외하고 [1, 2, 3] 번 학생이 같은 국적을 가지고 있습니다.
 * 따라서 대표 두 명을 뽑는 방법은 (1, 4), (2, 4), (3, 4)로 총 3가지입니다.
 *
 * 전체 학생 수 n, 같은 국적인 학생 쌍에 대한 정보가 담긴 2차원 배열 nationality가 매개변수로 주어질 때,
 * 대표 두 명을 뽑는 방법은 모두 몇 가지인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 2 이상 100 이하인 자연수입니다.
 * nationality의 세로(행) 길이는 1 이상 1,000 이하입니다.
 * nationality의 각 원소는 [a, b] 형태입니다.
 * a, b는 각각 같은 국적인 두 후보의 번호를 나타냅니다.
 * a, b는 1 이상 n 이하인 자연수이며, a와 b가 같은 경우는 주어지지 않습니다.
 * 같은 학생 쌍에 대한 정보는 한 번씩만 주어집니다.
 * 대표 두 명을 뽑는 방법이 없다면 0을 return 해주세요.
 * 입출력 예
 * n	nationality	result
 * 4	[[1,2],[2,3],[1,3]]	3
 * 5	[[1,2],[2,3]]	7
 */
class Test1_1 {
    private void display(int[] student) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< student.length;i++)
            sb.append(student[i]+" ");
        System.out.println(sb);
    }

    private int[] makeTeam(int[] student,int[][] nationality) {
        for(int i=0;i<nationality.length;i++){
            /*
                처음에 1, 2 가 들어왔다.
                둘다 같은 경우 -> 하나로 통일
                둘중 하나만 같은 경우, 둘다 다른 경우 -> 하나로 통일 가능하지 않을까?
            */
            int student1;
            int student2;
            if(nationality[i][0]<nationality[i][1]){
                student1=nationality[i][0];
                student2=nationality[i][1];
            }else{
                student1=nationality[i][1];
                student2=nationality[i][0];
            }
            //int arr[][]={{1,2},{1,4},{5,4},{6,8},{8,7},{7,1}};
            //{{1,2},{1,4},{4,5},{6,8},{7,8},{1,7},{9,1},{10,11},{10,13},{20,17},{14,5},{17,18},{18,3}};
            //
            if(student[student1]==student1&&student[student2]==student2){
                student[student2]=student1;
            }else {
                //System.out.println(student1+" df "+student[student1]);
               // System.out.println(student2+" df "+student[student2]);
                if (student[student1] == student1) {
                    //변수 1개를 이용해서 해결해야한다.
                    int temp=student[student2];

                    for (int j = 1; j < student.length; j++) {
                        if (student[j] == student1) {
                            student[j] = temp;
                        }
                    }
                } else if (student[student2] == student2) {
                    //변수 1개를 이용해서 해결해야한다.
                    int temp=student[student1];
                    for (int j = 1; j < student.length; j++) {
                        if (student[j] == student2)
                            student[j] = temp;
                    }
                } else {
                    System.out.println("2개의 그룹을 하나로 합치자!!");
                    //변수 2개를 이용해서 해결해야한다.
                    int temp=student[student1];
                    int compare=student[student2];

                    for (int j = 1; j < student.length; j++) {
                        if (student[j] == compare)
                            student[j] = temp;
                    }
                }
            }
            display(student);
        }
        return student;
    }

    private int totalCase(int[] student) {
        int sum=0;
        int total[]=new int[student.length];
        
        for(int i=1;i< student.length;i++){ //순서쌍 Count
            total[student[i]]+=1;
        }
        for(int i=1;i< student.length;i++){
            for(int j=i+1;j< student.length;j++)
                if(total[i]==0||total[j]==0)
                    continue;
                else
                    sum+=(total[i]*total[j]); //모든 경우의 수 구하기
        }

        display(total);
        return sum;
    }

    int solution3(int n, int[][] nationality){
        int student[]=new int[n+1];
        for(int i=1;i<student.length;i++)
            student[i]=i;

        student= makeTeam(student,nationality);
        int result= totalCase(student);
        return result;
    }
}
