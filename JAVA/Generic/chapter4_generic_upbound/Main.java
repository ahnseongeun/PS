package JAVA.Generic.chapter4_generic_upbound;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();

        int result1 = util.compare(20, 30);
        int result2 = util.compare(3.4, 2.5);
        int result3 = util.compare(3.0, 3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        //오류 발생생
       //int result4 = util.compare("test1","test1");
    }
}
