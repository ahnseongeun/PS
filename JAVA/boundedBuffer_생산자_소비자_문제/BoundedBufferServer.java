package JAVA.boundedBuffer_생산자_소비자_문제;

public class BoundedBufferServer {
    public static void main(String args[]){
        BoundedBuffer server = new BoundedBuffer();

        //now create the producer and consumer threads
        Producer producerThread = new Producer(server);
        Consumer consumerThread = new Consumer(server);

        producerThread.start();
        consumerThread.start();
    }
}
