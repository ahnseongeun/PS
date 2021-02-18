package JAVA.boundedBuffer_생산자_소비자_문제.세마포어가있을때;

public final class Semaphore {
    private int value;

    public Semaphore(){
        value = 0;
    }

    public Semaphore(int v){
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
