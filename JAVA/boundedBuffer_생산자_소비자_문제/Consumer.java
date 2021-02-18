package JAVA.boundedBuffer_생산자_소비자_문제;

import java.util.Date;

public class Consumer extends  Thread{
    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer b){
        this.buffer = b;
    }

    public void run(){
        Date message;
        while(true){
            BoundedBuffer.napping();
            //produce an item & enter it into the buffer
            System.out.println("Consumer wants to consume");

            message = (Date) buffer.remove();
        }
    }
}
