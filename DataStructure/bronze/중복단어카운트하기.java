package DataStructure.bronze;

public class 중복단어카운트하기 {
    public static void main(String[] args) throws Exception{
        //String str = "aab ade efab ba aab aba baa bbbbbaa babedfabd";
        String str = "dd";
        int idx = -1;
        int cnt = 0;
        String target = "ab";
        while(true){
            if(str.indexOf(target, idx) == -1 ) break;
            idx = (str.indexOf(target,idx) + target.length());
            System.out.println(idx);
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }
}
