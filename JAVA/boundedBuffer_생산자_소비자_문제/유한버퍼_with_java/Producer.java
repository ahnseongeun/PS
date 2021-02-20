package JAVA.boundedBuffer_생산자_소비자_문제.유한버퍼_with_java;

class Producer extends Thread {
    BoundedBuffer b;
    int N;
    Producer(BoundedBuffer b, int N) {
        this.b = b; this.N = N;
    }
    public void run() {
        for (int i=0; i<N; i++)
            b.insert(i);
    }
}
