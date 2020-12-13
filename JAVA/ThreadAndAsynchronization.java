package JAVA;

class sharedData {
    int n=10;
    int count=1;
    boolean ready=false;
}
class ReaderThread extends Thread {
    private int result;
    sharedData data;

    synchronized int share(sharedData data)
    {
        this.data=data;
        return data.count++;
    }
    public void run() {
        while(!data.ready) {
            System.out.println(share(data)-4+"번 쓰레드 실행");
            setResult(factorial(data.n));
            data.n=(data.n)-1;
            data.ready=true;
        }
        data.ready=false;
    }
    public int factorial(int n) {
        if(n==1) {
            //System.out.println(count);
            return n ;
        }
        else
            return n*factorial(n-1);
    }

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }



}

public class ThreadAndAsynchronization {

    public static void main(String[] args) {

        sharedData a= new sharedData(); //공유 데이터
        ReaderThread thread1=new ReaderThread();
        ReaderThread thread2=new ReaderThread();
        ReaderThread thread3=new ReaderThread();
        ReaderThread thread4=new ReaderThread();
        thread1.share(a);
        thread2.share(a);
        thread3.share(a);
        thread4.share(a);
//        thread1.data=a;
//        thread2.data=a;
//        thread3.data=a;
//        thread4.data=a;
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        StringBuilder sb=new StringBuilder();
        try {
            thread1.join();
            sb.append("1");
            thread2.join();
            sb.append("2");
            thread3.join();
            sb.append("3");
            thread4.join();
            sb.append("4");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        System.out.println("1번째 쓰레드결과값: "+thread1.getResult());
        System.out.println("2번째 쓰레드결과값: "+thread2.getResult());
        System.out.println("3번째 쓰레드결과값: "+thread3.getResult());
        System.out.println("4번째 쓰레드결과값: "+thread4.getResult());

        int total=thread1.getResult()+thread2.getResult()+thread3.getResult()+thread4.getResult();
        System.out.println("최종 합="+total);

        //number = 4;
    }
}


