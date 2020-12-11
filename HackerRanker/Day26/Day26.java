package HackerRanker.Day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day26 {
    private static boolean checkDay(int return_d, int due_d) {
        if(return_d>due_d)
            return true;
        return false;
    }

    private static boolean checkMonth(int return_m,int due_m) {
        if(return_m>due_m)
            return true;
        return false;
    }

    private static boolean checkYear(int return_y,int due_y) {
        if(return_y>due_y)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int return_d=Integer.parseInt(st.nextToken());
        int return_m=Integer.parseInt(st.nextToken());
        int return_y=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(input.readLine());
        int due_d=Integer.parseInt(st.nextToken());
        int due_m=Integer.parseInt(st.nextToken());
        int due_y=Integer.parseInt(st.nextToken());
        int total=0;

        if(checkYear(return_y,due_y)){
            total=10000;
            System.out.println(total);
        }else{
            if(return_y-due_y<0) {
                System.out.println(0);
            }else {
                if (checkMonth(return_m, due_m)) {
                    total = (return_m - due_m) * 500;
                    System.out.println(total);
                } else {
                    if (checkDay(return_d, due_d)) {
                        total = (return_d - due_d) * 15;
                        System.out.println(total);
                    } else {
                        System.out.println(0);
                    }
                }
            }
        }

    }
}
