package CodingTest.식스샵;

public class Test2 {
    public static void main(String[] args) {
        int[] grade = {3,2,1,2};
        int[] result = new int[1000001]; //해당 점수 count
        int[] ranks = new int[1000001]; //ranks 순위
        for(int i = 0; i < grade.length; i++) result[grade[i]]++;
        int rank = 1;
        for(int i = result.length - 1; i >= 1; i--){
            if(result[i] == 0) continue;
            ranks[i] = rank;
            rank += result[i];
        }
        for(int i = 0; i < grade.length; i++){
            grade[i] = ranks[grade[i]];
        }
        System.out.println(grade);
    }
}
