package DataStructure.진행중인문제;

public class 무조건반례 {

    private static int getSize(char[] str){
        int i;
        return str.length;
    }

    private static char[] CustomerReverse(char[] str) {
        int i;
        int len;
        char tmp;

        i = 0;
        len = getSize(str) - 1;
        while(len >= i){
            tmp = str[i];
            str[i] = str[len];
            str[len] = tmp;
            System.out.println(i + " " + len);
            i++;
            len--;
            display(str);
        }
        return str;
    }

    private static void display(char[] str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length; i++)
            sb.append(str[i] +" ");
        sb.append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args){
        char[] str = {'1','2','3','4','5','6','7','8','9'};
        System.out.println(CustomerReverse(str));
    }
}
