package CodingTest.식스샵;

public class Test5 {
    private static String getStringJoin(String str1, String str2) {
        for(int i = str1.length(); i >=  0; i--){
            if(!str2.endsWith(str1.substring(0, i))) continue;
            return str2 + str1.substring(i);
        }

        return str1 + str2;
    }

    public static void main(String[] args) throws Exception{
        String str1 = "A";
        String str2 = "AyA";
        String resultString1 = getStringJoin(str1,str2);
        String resultString2 = getStringJoin(str2,str1);
        if(resultString1.length() == resultString2.length()) {
            System.out.println(resultString1.compareTo(resultString2) < 0 ? resultString1 : resultString2);
        } else {
            System.out.println(resultString1.length() > resultString2.length() ? resultString2 : resultString1);
        }
    }
}
