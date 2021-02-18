package JAVA.boundedBuffer_생산자_소비자_문제;

import java.util.Date;

public class Producer extends Thread{

    private BoundedBuffer buffer;

    public Producer(BoundedBuffer b){
        this.buffer = b;
    }

    public void run(){
        Date message;
        while(true){
            BoundedBuffer.napping();
            //produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced" + message);
        }
    }

}
