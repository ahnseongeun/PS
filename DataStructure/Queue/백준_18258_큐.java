package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

public class 백준_18258_큐 {
    static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        Node start=null;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            String command="";
            if(st.countTokens()==2){
                command=st.nextToken();
                int number=Integer.parseInt(st.nextToken());

            }else{
                command=st.nextToken();
            }

        }
    }
}
