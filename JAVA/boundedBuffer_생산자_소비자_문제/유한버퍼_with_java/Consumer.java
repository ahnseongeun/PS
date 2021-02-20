package JAVA.boundedBuffer_생산자_소비자_문제.유한버퍼_with_java;

class Consumer extends Thread {
    BoundedBuffer b;
    int N;
    Consumer(BoundedBuffer b, int N) {
        this.b = b; this.N = N;
    }
    public void run() {
        int item;
        for (int i=0; i<N; i++)
            item = (int) b.remove();
    }
}
