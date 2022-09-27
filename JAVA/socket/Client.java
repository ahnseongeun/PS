package JAVA.socket;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception 
	{
		final Socket skt = new Socket("127.0.0.1",7891);
		final ObjectInputStream in = new ObjectInputStream( skt.getInputStream() );
		final ObjectOutputStream out = new ObjectOutputStream( skt.getOutputStream() );
		final BufferedReader bin = new BufferedReader(new InputStreamReader(System.in ));

		new Thread(() -> {
			try {
				boolean alive = true;
				while( alive ) {
					String l = in.readUTF();
					if( l.contains("!quit") ) {
						alive = false;
					} else if ( l.contains("!bye") ) {
						alive = false;
						System.out.println("클라이언트가 종료 되었습니다.");
					} else {
						System.out.println( "> " + l );
					}
				}
				System.out.println("종료 완료");
				bin.close();
				out.close();
				in.close();
				skt.close();

			}
			catch( Exception ignored) {}
		}).start();

		// 서버로 데이터를 넘길 때 사용
		String l;
		while(( l = bin.readLine() ) != null) {
			out.writeUTF(l);
			out.flush();
			if (l.equals("!quit")) {
				break;
			}
			if (l.equals("!bye")) {
				System.out.println("폭파");
				break;
			}
		}
	}
}