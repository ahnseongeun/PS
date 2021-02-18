package JAVA.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socket_server {
    public static void main(String[] args){
        try{
            ServerSocket sock=new ServerSocket(6013);
            System.out.println("여기?");
            /* now listen for connections */
            while(true){
                System.out.println("여기??");
                /* 여기서 client socket을 대기한다.*/
                Socket client = sock.accept();
                System.out.println("여기???");
                PrintWriter pout=new PrintWriter(client.getOutputStream(),true);
                /* write the content to the socket*/
                pout.println("hello client!!");

                /* close the socket and result, listening for connections */
                client.close();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
