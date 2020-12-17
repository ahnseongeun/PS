package 이것이코딩테스트다_BOOK.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
N명의 이름과 국어,영어,수학 점수가 주어집니다.
국어 점수 감소하는 순서 ,국어점수가 같으면 영어 점수가 증가하는 순서,
국어 점수와 영어 저수가 같으면 수학 점수가 감소하는 순서로,모든 점수가 같으면 이름이 사전순으로 증가
4가지를 비교할 때 가장 적절한 방법은?
접근 방법

 */
class Student{
    private String name;
    private int korean_score;
    private int english_score;
    private int math_score;
    Student(String name,int korean_score,int english_score, int math_score){
        this.name=name;
        this.korean_score=korean_score;
        this.english_score=english_score;
        this.math_score=math_score;
    }

    public String getName() {
        return name;
    }

    public int getKorean_score() {
        return korean_score;
    }

    public int getEnglish_score() {
        return english_score;
    }

    public int getMath_score() {
        return math_score;
    }

    public String toString(){

        return name+" "+ korean_score+ " "+english_score+" "+math_score;
    }
}
public class 국영수 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        List<Student> list=new LinkedList<>();
        StringTokenizer st;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(input.readLine());
            String name=st.nextToken();
            int korean_score=Integer.parseInt(st.nextToken());
            int english_score=Integer.parseInt(st.nextToken());
            int math_score=Integer.parseInt(st.nextToken());
            list.add(new Student(name,korean_score,english_score,math_score));
        }
        Collections.sort(list, (o1, o2) -> { //양수면 자리 바꿈 실행
            if(o1.getKorean_score()== o2.getKorean_score()&&
               o1.getMath_score()==o2.getMath_score()&&
               o1.getEnglish_score()==o2.getEnglish_score()){
                return o1.getName().compareTo(o2.getName());
            }else if(o1.getKorean_score()== o2.getKorean_score()&&
                     o1.getEnglish_score()==o2.getEnglish_score()){
                return o2.getMath_score()-o1.getMath_score();
            }else if(o1.getKorean_score()== o2.getKorean_score()){
                return o1.getEnglish_score()-o2.getEnglish_score();
            }else{
                return o2.getKorean_score()-o1.getKorean_score();
            }
        });

        for(Student student:list)
            System.out.println(student.getName());
    }
}
