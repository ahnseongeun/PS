package JAVA.Generic.chapter4_generic_upbound;

public class Util {

    //Number 타입은 int, long, double, short, float, byte
    public <T extends Number> int compare(T t1, T t2) {

        //가장 큰 범위의 double형으로 바꾸어 데이터 손실 방지
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return Double.compare(v1, v2);
    }
}
