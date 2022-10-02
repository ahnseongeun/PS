package JAVA.java;

import java.util.LinkedList;
import java.util.List;

interface IWork {
	public void execute( String by );
}

class WorkQueue {
	private List<IWork> queue = null ;
	
	public WorkQueue() {
		queue = new LinkedList<IWork>();
	}
	
	public synchronized void enqueue( IWork iw ) {
		queue.add( iw );
		notify();
	}
	
	public synchronized IWork dequeue() {
		while( queue.size() == 0 ) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		IWork t = queue.remove(0);
		return t;
	}	
}

class WorkImpl implements Runnable {
	private String name = null;
	private WorkQueue que = null;
	
	WorkImpl( String name, WorkQueue que ) {
		this.name = name;
		this.que = que;
	}
	
	@Override
	public void run() {
		while( true ) {
			IWork iw = que.dequeue();
			iw.execute( name );
		}
	}
}


class TestWork implements IWork {
	private int num = 0;
	
	public TestWork( int i ) {
		num = i;
	}
	
	@Override
	public void execute(String by) {
		for( int i = 0 ; i < 3 ; i++ ) {
			System.out.println( num + " WORK STEP " + i + " by " + by );
			
			int time = (int)( Math.random() * 1000 );
			try {
				Thread.sleep( time );
			} catch (InterruptedException e) {}
		}
		System.out.println( num + " WORK DONE by " + by );
	}
}

public class ThreadPool 
{
	private Thread[] threads = null;
	private WorkQueue queue = null;
	
	public ThreadPool( int size ) 
	{
		queue = new WorkQueue();
		
		threads = new Thread[size];
		for( int i = 0 ; i < size ; i++ ) {
			threads[i] = new Thread( new WorkImpl( "T"+i , queue ) );
			threads[i].start();
		}
	}
	
	public void doIt( IWork iw ) {
		queue.enqueue( iw );
	}
	
	public static void main( String[] args ) {
		ThreadPool tp = new ThreadPool( 3 );
		for( int i = 0 ; i < 10 ; i++ ) {
			tp.doIt( new TestWork( i ) );
		}
	}
}

/*

*/