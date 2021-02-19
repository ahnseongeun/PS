package JAVA.boundedBuffer_생산자_소비자_문제.세마포어_with_busyWaiting;

public final class Semaphorefd {
    private int value;

    public Semaphorefd(){
        value = 0;
    }

    public Semaphorefd(int v){
        value = v;
    }

    public synchronized void P() {// 원자적 실행
        while(value <= 0){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("P 오류");
            }
            value--;
        }
    }

    public synchronized void V() {// 원자적 실행
        ++value;
        notify();
    }
}
