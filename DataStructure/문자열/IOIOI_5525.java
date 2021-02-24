package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOIOI_5525 {

    /*
    접두사와 접미사가 일치하는 것을 구한다.
     */
    private static int[] makeTable(String pattern) {

        int patternSize = pattern.length();
        int[] table = new int[patternSize];

        int j = 0;
        //i가 0부터 시작하면 오류가 나는 이유는 table[j - 1]의 인덱스가 pattern의 최대 크기를 벗어 날수 있다.
        for(int i = 1; i < patternSize; i++){

            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j += 1;
                table[i] = j;
            }
        }

        return table;
    }

    private static int kmp(String parent, String pattern) {

        int count = 0;
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int[] table = makeTable(pattern);

        int j = 0;
        for(int i = 0; i < parentSize; i++){
            while(j > 0 && parent.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }

            if(parent.charAt(i) == pattern.charAt(j)){
                if(j == patternSize - 1){
                    j = table[j];
                    count++;
                }else{
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder("IOI");
        for(int i = 1; i < n; i++)
            sb.append("OI");

        int m = Integer.parseInt(input.readLine());
        String pattern = sb.toString();
        String parent = input.readLine();
        System.out.println(kmp(parent,pattern));

    }
}
