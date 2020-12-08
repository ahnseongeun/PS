package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
[0, 1, 2, 3, 4, 5, 6, 7]
[0, 1, 2, 4, 5, 6, 7]
[0, 1, 2, 4, 5, 7]
[0, 1, 4, 5, 7]
[0, 1, 4, 5]
[0, 1, 4]
[0, 4]
<3, 6, 2, 7, 5, 1, 4>
 */
//원형으로 푸는 방법은 통과되지 않는다
public class 요세푸스문제2_1168 {
    public static void main(String[] args) throws  Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        sb.append('<');
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        int start=0;
        for(int i=0;i<n-1;i++){ //n
            start=(start+k);
            if(start>=list.size())
                start%=list.size();
            sb.append(list.remove(start)+", "); //remove할때도 n에 근접
        }
        //결과적으로 n^2이라서 실패하는 것이 아닌지?
        sb.append(list.remove(0)+">");
        System.out.println(sb.toString());
        input.close();
    }
}
/*
for(int i=0;i<=n;i++)
            list.add(i);
        int start=1;
        int size=list.size();
        for(int i=1;i<=n;i++){
            start=(start+(k-1))%(size-i);
            if(start==0)
                start=list.size()-1;
            sb.append(list.remove(start)+", ");
        }
        System.out.println(sb.substring(0,sb.length()-2)+">");
 */