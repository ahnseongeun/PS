package JAVA;

public class JAVA_객체비교 {
    public static void main(String[] args){
        int a = 1;
        int b = 1;
        //int c = null;
        if(a==b)
            System.out.println("두수는 같다.");
        else
            System.out.println("두수는 다르다.");

        Integer test1 = 1666;
        Integer test2 = 1666;
        Integer test3 = null;
        if(test1==test2)
            System.out.println("두수는 같다.");
        else
            System.out.println("두수는 다르다.");

        String str1 = "hello";
        String str2 = "hello";
        if(str1.equals(str2))
            System.out.println("두 문자열은 같다.");
        else
            System.out.println("두 문자열은 다르다.");
    }
}
