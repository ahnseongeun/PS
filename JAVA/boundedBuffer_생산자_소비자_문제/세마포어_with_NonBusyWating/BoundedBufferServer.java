package JAVA.boundedBuffer_생산자_소비자_문제.세마포어_with_NonBusyWating;


/**
 * BusyWaiiting을 이용할 때 숫자가 커질 수록 BusyWaiting을 이용하지 않는 것이 효율적이다.
 */
public class BoundedBufferServer {
    public static void main(String args[]){
        long beforeTime = System.currentTimeMillis();
        Buffer server = new Buffer(100);

        //now create the producer and consumer threads
        Producer producerThread = new Producer(server,10000);
        Consumer consumerThread = new Consumer(server,10000);

        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
            System.out.println("최종 버퍼의 크기: " + server.count);
            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime);
            System.out.println("시간차이(m) : "+secDiffTime);
        } catch (InterruptedException e) {
            System.out.println("Number of items in the buf is " + server.count);
        }
    }
}
