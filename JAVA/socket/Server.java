package JAVA.socket;

import java.net.ServerSocket;
import java.net.Socket;

import static JAVA.socket.UnitClient.clients;

/**
 * Server와 Client간의 소켓 통신을 통한 채팅 구현
 * 	1. 각 쓰레드에 유저 닉네임 부여
 * 	2. 방 폭파하기
 */
public class Server {
	
	private static int clientNumber = 0;
	
	public static void main(String[] args) throws Exception {
		ServerSocket svr = new ServerSocket(7891);
		
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			System.out.println( "입장 : " + skt.toString() );
			clientNumber += 1;
			String name = "nickname" + clientNumber;
			
			new Thread( new UnitClient( skt, name ) ).start();
		}
		svr.close();
	}
}