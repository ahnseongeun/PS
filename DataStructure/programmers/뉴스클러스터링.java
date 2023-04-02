package DataStructure.programmers;


import java.util.HashMap;

/*
1. 교집합 크기를 합집합 크기로 나눈다.
    - 공집합일 때 1
    - 다중집합 가능 (SET은 쓸수가 없다.)
    - 문자열일 경우 앞에서 부터 두 개씩 끊어서 부분 집함 만들 수 있다.
정규식으로 영문자만 적용, 소문자로 변환

- 완전 탐색
최대 1000일 때
시간복잡도는 500000만

- 교집합의 수와 합집합의 수를 구하는 로직

 */
public class 뉴스클러스터링 {

    static HashMap<String, Integer> countMap1 = new HashMap<>();
    static HashMap<String, Integer> countMap2 = new HashMap<>();

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "aaa";

        makePartitionString(str1, str2);
        System.out.println(calculateIntersectionDivideUnion());
        // 부분 문자열을 만들었다면
    }

    private static int calculateIntersectionDivideUnion() {

        double intersectionCount = 0;
        double unionCount = countMap1.values().stream().mapToInt(Integer::intValue).sum()
                + countMap2.values().stream().mapToInt(Integer::intValue).sum();

        for (String key : countMap1.keySet()) {
            if (countMap2.get(key) != null) {
                intersectionCount += Math.min(countMap1.get(key), countMap2.get(key));
                countMap2.remove(key);
            }
        }

        System.out.println(intersectionCount);
        System.out.println(unionCount);

        if ( intersectionCount == 0 && unionCount == 0) return 65536;
        unionCount -= intersectionCount;

        return (int) (intersectionCount / unionCount * 65536);
    }

    private static void makePartitionString(String newStr1, String newStr2) {
        for ( int i = 0; i < newStr1.length() - 1; i++) {
            String str = newStr1.substring(i, i + 2).toLowerCase();
            if ( checkAlphabet(str)) {
                countMap1.put(str, countMap1.getOrDefault(str, 0) + 1);
            }
        }

        for ( int i = 0; i < newStr2.length() - 1; i++) {
            String str = newStr2.substring(i, i + 2).toLowerCase();
            if ( checkAlphabet(str)) {
                countMap2.put(str, countMap2.getOrDefault(str, 0) + 1);
            }
        }
    }

    private static boolean checkAlphabet(String newStr) {
        char ch1 = newStr.charAt(0);
        char ch2 = newStr.charAt(1);
        if ( ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') return true;
        return false;
    }

//    private static String makeOnlyAlphabet(String str1) {
//        StringBuilder sb = new StringBuilder();
//        for( char ch : str1.toLowerCase().toCharArray()) {
//            if ( ch >= 'a' && ch <= 'z') sb.append(ch);
//        }
//        return sb.toString();
//    }
}
