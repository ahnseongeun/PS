package CodingTest.가비아;

public class Test1 {

    private static String reverseString(String str) {
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length() / 2; i++) {
            char ch = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = ch;
        }
        return new String(arr);
    }

    public static void main(String[] args) throws Exception {
        String S = "abcde";
        int[][] interval = {{4,5},{1,2},{3,3}};
        for(int i = 0; i < interval.length ; i++) {
            int startIdx = interval[i][0] - 1;
            int endIdx = interval[i][1];
            String subString = reverseString(S.substring(startIdx, endIdx));
            String startString = S.substring(0, startIdx);
            String endString = S.substring(endIdx);
            S = startString + subString + endString;
        }
        System.out.println(S);
    }
}
