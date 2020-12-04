package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


//좀더 나은풀이법
//Sort를 먼저하고 비교하면 시간과 공간을 단축시킬수 있다.
public class 백준_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int count=0;
        Set<String> set=new HashSet<>();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            set.add(input.readLine());
        for(int i=0;i<m;i++){
            String str=input.readLine();
            if(set.contains(str)){
                list.add(str);
                count++;
            }
        }
        Collections.sort(list);
        for(String str:list)
            sb.append(str+"\n");
        System.out.println(count+"\n"+sb);
    }
}
