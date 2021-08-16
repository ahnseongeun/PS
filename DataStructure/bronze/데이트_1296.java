package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
OHMINSIK
9
YOONA
TIFFANY
YURI
HYOYEON
SOOYOUNG
SEOHYUN
TAEYEON
JESSICA
SUNNY
 */
public class 데이트_1296 {

    private static int getCount(String name, char target) {
        int cnt = 0;
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == target) cnt++;
        }
        return cnt;
    }

    static int getMax(String name, String girlName) {

        int L = getCount(name, 'L') + getCount(girlName, 'L');
        int O = getCount(name, 'O') + getCount(girlName, 'O');
        int V = getCount(name, 'V') + getCount(girlName, 'V');
        int E = getCount(name, 'E') + getCount(girlName, 'E');
        return ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = input.readLine();
        int n = Integer.parseInt(input.readLine());
        int max = -1;
        ArrayList<String> nameList = new ArrayList<>();
        String result = "";
        for(int i = 0; i < n; i++) {
            String girlName = input.readLine();
            int number = getMax(name, girlName);
            if( max < number) {
                max = number;
                result = girlName;
                nameList = new ArrayList<>();
                nameList.add(result);
            } else if( max == number){
                nameList.add(girlName);
            }
        }
        Collections.sort(nameList);
        System.out.println(nameList.get(0));
    }
}
