package JAVA;

import java.util.Arrays;

public class char_to_index {
    public static void main(String[] args){

        String str = "zdefs";
        int arr[] = new int[str.length()];
        for(int i = 0; i < str.length(); i++)
            arr[i] = str.charAt(i);
        System.out.println(arr[3]);
        System.out.println(str.indexOf("e"));
        System.out.println(str.indexOf("zded"));
    }
}
