package JAVA;

class sharedData {
    int n=4;
    int count=1;
    boolean ready=false;
}
class ReaderThread extends Thread {
    private int result;
    sharedData data;

    public synchronized void share(sharedData data)
    {
        this.data=data;
    }
    public void run() {
        while(!data.ready) {
            System.out.println(data.count+"번 쓰레드 실행");
            share(data);
            setResult(factorial(data.n,data.count));
            data.n=(data.n)-1;
            data.ready=true;
            System.out.println(data.count+"번 쓰레드 종료");
            data.count++;
        }
        data.ready=false;
    }
    public static int factorial(int n,int count) {
        if(n==1) {
            //System.out.println(count);
            return n ;
        }
        else
            return n*factorial(n-1,count);
    }

    public int getResult() {
        return result;
    }
    public  void setResult(int result) {
        this.result = result;
    }



}

public class ThreadAndAsynchronization {

    public static void main(String[] args) {


        ReaderThread thread1=new ReaderThread();
        ReaderThread thread2=new ReaderThread();
        ReaderThread thread3=new ReaderThread();
        ReaderThread thread4=new ReaderThread();
        sharedData a= new sharedData(); //공유 데이터

        thread1.data=a;
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread2.data=a;
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread3.data=a;
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread4.data=a;
        thread4.start();
        try {
            thread4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        System.out.println("1번째 쓰레드결과값: "+thread1.getResult());
        System.out.println("2번째 쓰레드결과값: "+thread2.getResult());
        System.out.println("3번째 쓰레드결과값: "+thread3.getResult());
        System.out.println("4번째 쓰레드결과값: "+thread4.getResult());

        int total=thread1.getResult()+thread2.getResult()+thread3.getResult()+thread4.getResult();
        System.out.println("최종 합="+total);

        //number = 4;
    }
}


