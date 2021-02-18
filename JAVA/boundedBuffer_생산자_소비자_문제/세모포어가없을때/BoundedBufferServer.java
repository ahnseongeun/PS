package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;


public class BoundedBufferServer {
    public static void main(String args[]){
        Buffer server = new Buffer(10000);

        //now create the producer and consumer threads
        Producer producerThread = new Producer(server,100000);
        Consumer consumerThread = new Consumer(server,100000);

        producerThread.start();
        consumerThread.start();

        try{
            producerThread.join();
            consumerThread.join();
            System.out.println(server.getCount1());
        } catch (InterruptedException e) {
            System.out.println("Number of items in the buf is " + server.getCount());
        }
    }
}
