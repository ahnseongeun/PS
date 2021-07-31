package DataStructure.진행중인문제;

public class 삼육구 {
    public static void main(String[] args) throws Exception{
        int n = 50;
        while( n != 0) {
            int x = n % 10;
            System.out.println(x);
            n /= 10;
        }
    }
}
