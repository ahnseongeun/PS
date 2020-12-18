package 이것이코딩테스트다_BOOK.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class node_4 implements Comparable<node_4>{
    String name="";
    int x=0;
    int y=0;
    int z=0;
    node_4(String name,int x,int y, int z){
        this.name=name;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    @Override
    public int compareTo(node_4 o) {
        if(this.x==o.x&&this.y==o.y&&this.z==o.z)
            return this.name.compareTo(o.name); //문자열 비교
        if(this.x==o.x&&this.y==o.y)
            return o.z-this.z; //감소로 정렬
        if(this.x==o.x)
            return this.y-o.y; //증가로 정렬
        return o.x-this.x;
        // TODO Auto-generated method stub
    }
}

public class 국영수2 {

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(input.readLine());
        ArrayList<node_4> list=new ArrayList<node_4>();
        for(int i=1;i<=n;i++)
        {
            StringTokenizer st=new StringTokenizer(input.readLine());
            String name=st.nextToken();
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            node_4 node=new node_4(name,a,b,c);
            list.add(node);
        }
        Collections.sort(list);
        for(int i=1;i<=n;i++)
            output.write(list.get(i-1).name+"\n");
        output.close();
        // TODO Auto-generated method stub

    }

}
