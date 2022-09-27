package JAVA.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class UnitClient implements Runnable 
{
	static List<UnitClient> clients = null;
	static {
		clients = new LinkedList<UnitClient>();
	}
	
	String name = null;
	Socket skt = null;
	ObjectOutputStream out = null;
	ObjectInputStream in = null;
	
	UnitClient( Socket sk, String name) throws Exception {
		this.name = name;
		this.skt = sk;
		this.out = new ObjectOutputStream( sk.getOutputStream() );
		this.in = new ObjectInputStream( sk.getInputStream() );
		
		clients.add( this );
	}
	
	public static void broadcast( String l, UnitClient self ) throws Exception {
		/*
			처음에는 UserClient를 죽이고 Client 쓰레드를 죽여야한다고 생각해서
			UserClient를 먼저 죽이려고했지만 현재 실행죽인 UserClient를 죽이면
			현재 실행죽인 쓰레드를 죽이면 그 다음 진행해야하는 일이 진행이 안됐다.
			=> 클라이언트 쓰레드 죽여버리고 서버를 죽이면 방 폭파 완료
		 */
		if (l.equals("!bye")) {
			System.out.println("BYE~~");
			for (UnitClient uc : clients) {
				if (self != uc) {
					System.out.println(uc.name + "이 종료되었습니다.");
					uc.out.writeUTF("!bye");
					uc.out.flush();
				}
			}
			self.out.writeUTF("!bye");
			self.out.flush();
		} else {
			for (UnitClient uc : clients) {
				String nickname = self.name;
				if (self != uc) {
					uc.out.writeUTF(nickname + " : " + l);
					uc.out.flush();
				}
			}
		}

	}
	
	@Override
	public void run() {
		try {
			boolean check = true;
			while( check ) {
				//다른 클라이언트에서는 여기서 걸려 있다.
				String l = in.readUTF();
				if( l.equals("!quit") ) {
					out.writeUTF("!exit");
					out.flush();
					check = false;
				}
				else if (l.equals("!bye")) {
					broadcast( "!bye", this );
					check = false;
				}
				else {
					broadcast( l, this );
				}
			}

			in.close();
			out.close();
			skt.close();
			
			clients.remove( this );
			System.out.println( "퇴장 : " + skt.toString() );
		}
		catch( Exception e ) {}
	}

	@Override
	public String toString() {
		return "UnitClient [name=" + name + "]";
	}
	
	
}
