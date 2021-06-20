package CodingTest.요기요;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Exameple.com";
        HashMap<String,Integer> names = new HashMap<>();
        StringTokenizer st = new StringTokenizer(str,";");
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String[] fullName = st.nextToken().trim().toLowerCase().split(" ");
            String convertName = fullName[0] + "." + fullName[fullName.length - 1];
            if(names.containsKey(convertName)){
                int cnt = names.get(convertName);

                names.put(convertName, cnt + 1);
            } else{
                names.put(convertName, 2);
            }
        }
        sb.append("test");
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString().substring(0,sb.length() - 1);
        System.out.println(sb);
        System.out.println(names);

    }
}
