package JAVA.boundedBuffer_생산자_소비자_문제.세모포어가없을때;

import java.util.Date;

class Consumer extends Thread {
    Buffer b;
    int N;
    Consumer(Buffer b, int N) {
        this.b = b; this.N = N;
    }
    public void run() {
        int item;
        for (int i=0; i<N; i++)
            item = b.remove();
    }
}
