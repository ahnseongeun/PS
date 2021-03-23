package CodingTest.라인;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 */
public class Test1 {
    //String[] table, String[] languages, int[] preference
    public static void main(String[] args){
//1 -> 5, 2- > 4 3-> 3 4 -> 2 5 -> 1
        String tables[] = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String languages[] = {"PYTHON", "C++", "SQL"};
        int preference[] = {7, 5, 5};

        String test = "basc";
        System.out.println(test.indexOf('4'));
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String, Integer> convertorPreference = new HashMap<>();
        for(int i = 0; i < preference.length; i++)
            convertorPreference.put(languages[i],preference[i]);


        HashMap<Integer, Integer> convertorCount = new HashMap<>();
        int count = 5; //점수
        for(int i = 1; i  <= 5; i++)
            convertorCount.put(i, count--);

        HashMap<String, Integer> result = new HashMap<>();

        for(int i = 0 ; i < 5; i++){ //가로
                int sum = 0;
                String[] tmp = tables[i].split(" ");
                for(int k = 0; k < languages.length ; k++){ //languages 비교
                    String lang = languages[k];
                    for(int cnt = 1; cnt < tmp.length; cnt++){
                        if(tmp[cnt].equals(lang)) {
                            sum += convertorCount.get(cnt) * convertorPreference.get(lang);
                            break;
                        }
                    }
                }
                result.put(tmp[0],sum);
        }
        System.out.println(result.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
    }
}
