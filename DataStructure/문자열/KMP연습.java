package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
ababacabacaabacaaba
abacaaba
 */
public class KMP연습 {

    /**
     * makeTable을 이용해서 실패했을 경우 j의 시작위치를 정할수 있다.
     * @param parent
     * @param pattern
     */
    private static void kmp(String parent, String pattern) {

        int[] table = makeTable(pattern);
        System.out.println(Arrays.toString(Arrays.stream(table).toArray()));
        int parentSize = parent.length();
        int patternSize = pattern.length();

        int j = 0;
        for(int i = 0; i < parentSize; i++){

            while(j > 0 && parent.charAt(i) != pattern.charAt(j)){
                j = table[j - 1];
            }

            if(parent.charAt(i) == pattern.charAt(j)){
                if(j == patternSize - 1){
                    System.out.println((i - patternSize + 2) +"번째 index에서 일치합니다.");
                    j = table[j];
                }else{
                    j++;
                }
            }
        }
    }

    /**
     * 매칭에 실패했을 경우 0부터 다시 하나씩 비교하는 것이 아니라
     * 접두사와 접미사를 이용해서 구해놨던 값부터 시작해서 최대한 효율적부분 부터 탐색 시작위치 저장
     * @param parent
     * @return
     */
    private static int[] makeTable(String parent) {
        int size = parent.length();
        int[] table = new int[size];
        int j = 0;

        for(int i = 1; i < size; i++) {

            //두 문자가 일치 하지 않는다면 j값을 이전 테이블 인덱스 - 1 로 이동
            while(j > 0 && parent.charAt(i) != parent.charAt(j)) {
                j = table[j - 1];
            }

            //두 문자가 일치하면 현재 테이블에 j + 1한 값을 넣는다.
            if(parent.charAt(i) == parent.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String parent = input.readLine();
        String pattern = input.readLine();
        kmp(parent,pattern);
    }
}
