package 이것이코딩테스트다_BOOK.그리디;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그리디인 배수를 이용해서 하는 것이 압도적으로 속도가 빠르다.
 */
public class 일이될때까지{
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        long n=Long.parseLong(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        long target=n;
        int cnt=0;
        long currentTime=System.currentTimeMillis();
        while(true){
            if(target==1)
                break;
            cnt++;
            if(target%m==0){
                target/=m;
            }else{
                target-=1;
            }
        }
        System.out.println("first"+cnt);
        long finishTime=System.currentTimeMillis();
        System.out.println("Total time1: "+(finishTime-currentTime));
        long result=0;
        currentTime=System.currentTimeMillis();
        while(true){
            //나눠지지 않는 수만큼 더하는 로직{
            target=(n/m)*m; //몫계산
            result += (n-target); //타켓에서 몫을 뺀만 큼 더 해준다.
            n = target; //새로운 몫으로 교체
            //}

            if(n<m) //몫이 나누는 수보다 작다면 반복문 교체
                break;

            //n을 나누는 로직{
            n /= m;
            result += 1;
            //}
        }
        result += (n-1);
        System.out.println("second"+result);
        finishTime = System.currentTimeMillis();
        System.out.println("Total time2: "+(finishTime-currentTime));
    }
}
