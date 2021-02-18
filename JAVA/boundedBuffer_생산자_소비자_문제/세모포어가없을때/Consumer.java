package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;

import java.util.Date;

public class Consumer extends  Thread{

    private Buffer buffer;
    private int n;

    public Consumer(Buffer b,int n){
        this.buffer = b;
        this.n = n;
    }

    public void run(){
        int item;
        for(int i = 0; i <= n; i++){
            System.out.println("소비자입니다: " + i);
            item = (int) buffer.remove();
            System.out.println("소비자 기준 버퍼의 크기: " + buffer.getCount());
        }
    }
}
