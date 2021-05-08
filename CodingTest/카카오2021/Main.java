package CodingTest.카카오2021;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        Test3 test3 = new Test3();
        System.out.println(test3.solution(n,k,cmd));
    }
}
