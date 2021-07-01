package DataStructure.bronze;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 밀비급일_11365 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = input.readLine();
            if(str.equals("END")) break;
            sb.append(new StringBuilder(str).reverse()).append("\n");
        }
        System.out.println(sb);

    }
}
