package DataStructure.programmers;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/*

주어진 배열에서 원소에 대한 순서를 리턴하는 문제

1. 문자열을 문자 배열로 변환
2. 문자열 배열의 길이 별로 없는 값을 새롭게 채워넣기
3. return 하는 원소의 개수가 500개 이기 때문에 정렬이 가능할 듯?
- 특수문자 치환 구글링
- 값 검증을 위해서 Set 사용, 빠른 조회
 */

public class 튜플 {

    public static HashSet<Integer> set;

    public static void main(String[] args) {
        set = new HashSet<>();
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        String[] subStrings = getSubStringArray(s);
        int[] result = new int[subStrings.length];
        Arrays.sort(subStrings, Comparator.comparingInt(String::length));
        for (int i = 0; i < subStrings.length; i++) {
            result[i] = getTupleNumber(subStrings[i]);
            set.add(result[i]);
        }
        System.out.println(result);
    }

    private static int getTupleNumber(String subString) {
        String[] numbers = subString.replace("}","").split(",");
        int tupleNumber = -1;
        for( String number : numbers) {
            tupleNumber = Integer.parseInt(number);
            if (set.contains(tupleNumber)) continue;
            break;
        }
        return tupleNumber;
    }

    private static String[] getSubStringArray(String s) {
        return s.substring(2, s.length() - 2)
                .replaceAll("[{]", "")
                .split("},");
    }
}
