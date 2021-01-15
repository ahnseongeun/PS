package 이것이코딩테스트다_BOOK.구현;

public class Main {
    public static void main(String[] args){
        외벽점검 test =new 외벽점검();
        int n=12;
        int weak[]={1, 5, 6, 10};
        int dist[]={1, 2, 3, 4};
        System.out.println(test.solution(n,weak,dist));
    }
}
