package JAVA;

import java.io.Serializable;

public class IO_TEST implements Serializable {
    public static void main(String[] args) {
        char[] chars = "HELLO".toCharArray();
        String str1 = new String(chars,2,1);
        System.out.println(str1);
    }
}
