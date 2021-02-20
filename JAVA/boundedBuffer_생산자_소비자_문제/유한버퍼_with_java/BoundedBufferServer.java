package JAVA.boundedBuffer_생산자_소비자_문제.유한버퍼_with_java;

public class BoundedBufferServer {
    public static void main(String args[]){
        BoundedBuffer server = new BoundedBuffer();

        //now create the producer and consumer threads
        Producer producerThread = new Producer(server,100000);
        Consumer consumerThread = new Consumer(server,100000);

        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
            System.out.println(server.getCount());
        } catch (InterruptedException e) {
        }
    }
}
