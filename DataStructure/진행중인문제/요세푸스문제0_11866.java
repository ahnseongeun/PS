package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

//<3, 6, 2, 7, 5, 1, 4>
//n으로 mod 하는 것이 아닌 list.size로 mod하는 것이 핵심이다.
public class 요세푸스문제0_11866 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 1;i <= n;i++)
            list.add(i);

        int idx = m - 1;
        while(true){
            result.add(list.get(idx));
            list.remove(idx);
            if(list.isEmpty())
                break;
            idx = (idx + m - 1) % list.size();
        }

        System.out.println("<"+result.toString().substring(1,result.toString().length()-1)+">");
    }
}
