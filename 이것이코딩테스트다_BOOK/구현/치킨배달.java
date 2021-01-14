package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {

    static int m;
    static int result = Integer.MAX_VALUE;
    static ArrayList<int[]> list;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> home;
    private static void calMin(int start, int index) {
        if(index==m){
            int sum=0;
            for(int i=0;i<home.size();i++){
                int min=10000;
                int y=home.get(i)[0];
                int x=home.get(i)[1];
                for(int j=0;j<list.size();j++){
                    int chicken_y=list.get(j)[0];
                    int chicken_x=list.get(j)[1];
                    min=Math.min(min,Math.abs(chicken_y-y)+Math.abs(chicken_x-x));
                }
                sum+=min;
            }
            result=Math.min(result,sum);
            return;
        }
        for(int i = start;i<chicken.size();i++){
            list.add(chicken.get(i));
            calMin(i+1,index+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        chicken=new ArrayList<>();
        home=new ArrayList<>();
        list=new ArrayList<>();

        for(int i = 0; i < n; i++){ //y
            st=new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){ //x
                int tmp=Integer.parseInt(st.nextToken());
                if(tmp == 1)
                    home.add(new int[]{j,i});
                if(tmp == 2)
                    chicken.add(new int[]{j,i});
            }
        }
        calMin(0,0);
        System.out.println(result);
    }
}
