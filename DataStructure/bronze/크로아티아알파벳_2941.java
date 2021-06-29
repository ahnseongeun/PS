package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
č	c=
ć	c-
dž	dz=
đ	d-
lj	lj
nj	nj
š	s=
ž	z=
 */
//ljes=njak
public class 크로아티아알파벳_2941 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = {"a","b","c","d","e","x","y","z"};
        String target = input.readLine()
                .replace("c=","a")
                .replace("c-","b")
                .replace("s=","c")
                .replace("dz=","x")
                .replace("d-","d")
                .replace("z=","e")
                .replace("lj","y")
                .replace("nj","z");
        int cnt = 0;
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            while(target.contains(word)) {
                target = target.replaceFirst(word, "");
                cnt++;
            }
        }
        System.out.println(cnt + target.length());
    }
}
