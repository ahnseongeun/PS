package JAVA.조건변수;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Cleaner implements Runnable {

    private Toilet toilet;
    private ReentrantLock lock;
    private Condition forCleaner;
    private Condition forPerson;

    // 해당 청소부가 관리하는 화장실 등록
    // lock, lock을 위한 Condition 인스턴스 생성
    public Cleaner(Toilet toilet, ReentrantLock lock, Condition forCleaner, Condition forPerson) {
        this.toilet = toilet;
        this.lock = lock;
        this.forCleaner = forCleaner;
        this.forPerson = forPerson;
    }

    public void replacePaper(int p) {
        toilet.setPaper(p);
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        while (true) {

            // 화장실은 혼자만 사용 가능
            // 여러 스레드가 접근하지 못한다.
            // 잠겨있다면 lock을 잡을때까지 잠시 대기
            lock.lock();
            try {
                // 휴지를 충전할 필요가 없다면 하지 않는다.
                if (toilet.getPaper() <= 0) {
                    System.out.println(name + " replaces toilet paper.");
                    replacePaper(7);
                    // 다른 사람들에게 화장실이 사용 가능함을 알려준다.
                    System.out.println("Finish. Wake everybody.");
                    forPerson.signalAll();
                }
                // 아직 휴지가 충분하면 바로 화장실을 나와서 자신의 대기실로 이동
                try {
                    System.out.println(name + " Go to wait.");
                    forCleaner.await();
                    Thread.sleep(500);
                    System.out.println(name + " wakes.");
                }
                //
                catch (Exception e) {
                    System.out.println("뭔데4");
                    e.printStackTrace();
                }

            }
            //
            finally {
                System.out.println("뭔데5");
                lock.unlock();
            }
        }
    }
}