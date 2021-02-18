package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;

import java.util.Date;

public class Producer extends Thread{

    private Buffer buffer;
    private int n;

    public Producer(Buffer b, int n){
        this.buffer = b;
        this.n = n;
    }

    public void run(){
       for(int i = 0; i <= n; i++) {
           System.out.println("생산자입니다: " + i);
           buffer.insert(i);
           System.out.println("생산자 기준 버퍼의 크기: " + buffer.getCount());
       }
    }

}
