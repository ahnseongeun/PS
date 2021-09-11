package CodingTest.라인2021;

public class Test5 {

    static int[] check;
    static int[] check2;
    static int[] result;
    static void checkNick(String[] nicks) {

        for(int i = 0; i < check.length; i++) {
            String str1 = nicks[i];
            for(int j = i + 1; j < check.length; j++) {
                String str2 = nicks[j];
                if(str1.equals(str2)) continue;
                if(Math.abs(str1.length() - str2.length()) > 2) {
                    continue;
                }
                int sizeMax = Math.max(str1.length(), str2.length());
                int sizeMin = Math.min(str1.length(), str2.length());
                int len = lcs(str1, str2);
                if(len < sizeMax && len >= sizeMax - 2 && len >= sizeMin) {
                    System.out.println(str1 + " " + str2 + " " + len);
                    check[j] = find(i);
                }
            }
        }

    }

    static int find(int i) {
        if(i == check[i]) return i;
        return find(check[i]);
    }

    static int lcs(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        int max = 0;
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;

    }

    static void checkEmail(String[] emails) {

        for(int i = 0; i < check2.length; i++) {
            String email1 = emails[i].substring(0,emails[i].indexOf("@"));
            String server1 = emails[i].substring(emails[i].indexOf("@") + 1);
            for(int j = i + 1; j < check2.length; j++) {
                String email2 = emails[j].substring(0,emails[j].indexOf("@"));
                String server2 = emails[i].substring(emails[i].indexOf("@") + 1);
                if(email1.equals(email2)) {
                    check2[j] = find(i);
                    continue;
                }
                if(!server1.equals(server2)) {
                    continue;
                }
                if(Math.abs(email1.length() - email2.length()) > 1) {
                    continue;
                }
                int sizeMax = Math.max(email1.length(), email2.length());
                int sizeMin = Math.min(server1.length(), server2.length());
                int len = lcs(email1, email2);
                if(len < sizeMax && len >= sizeMax - 1 && len >= sizeMin) {
                    System.out.println(email1 + " " + email2 + " " + len);
                    check2[j] = find(i);
                }
            }
        }

    }

    public static void main(String[] args) {

        String[] nicks = {"99police", "99poli44"};
        String[] emails = {"687ufq687@aaa.xx.yyy", "87ufq687@aaa.xx.yyy"};

        check = new int[nicks.length];
        check2 = new int[emails.length];
        result = new int[nicks.length];
        for(int i = 0; i < check.length; i++) check[i] = i;
        for(int i = 0; i < check2.length; i++) check2[i] = i;
        checkNick(nicks);
        checkEmail(emails);

        for(int i = 0; i < result.length; i++) {
            if(check[i] == check2[i]) result[i] = check[i];
            else {
                result[i] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < check.length; i++) {
            sb.append(check[i]).append(" ");
        }
        sb.append("\n");
        for(int i = 0; i < check2.length; i++) {
            sb.append(check2[i]).append(" ");
        }
        System.out.println(sb);
    }
}
