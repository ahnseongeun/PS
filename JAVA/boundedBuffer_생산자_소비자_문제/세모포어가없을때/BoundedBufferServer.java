package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;


public class BoundedBufferServer {
    public static void main(String args[]){
        Buffer server = new Buffer(100);

        //now create the producer and consumer threads
        Producer producerThread = new Producer(server,10000);
        Consumer consumerThread = new Consumer(server,10000);

        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
            System.out.println("최종 인덱스는: " + server.count);
        } catch (InterruptedException e) {
            System.out.println("Number of items in the buf is " + server.count);
        }
    }
}
