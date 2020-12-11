package HackerRanker.Day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day26 {
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
        if(return_y<due_y){
            System.out.println(total);
        }else if(return_y==due_y){
            if(return_m<due_m){
                System.out.println(total);
            }else if(return_m==due_m){
                if(return_d<due_d){
                    System.out.println(total);
                }else{
                    total=return_d-due_d;
                    System.out.println(total);
                }
            }else{
                if(return_d<due_d){
                    System.out.println(total);
                }else{

                }
            }
        }else{//반납년도가 만료년도보다 빠를경우 년기준
            if(return_m<due_m){//반납월이 만료월보다 빠를경우 월기준
                System.out.println(total);
            }else{
                if(return_d<due_d){//반납월이 만료월보다 빠를경우 월기준
                    System.out.println(total);
                }else{

                }
            }
        }
    }
}
