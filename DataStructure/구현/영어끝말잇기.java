package DataStructure.구현;


import java.util.HashSet;
import java.util.Set;

/**
1부터 n까지 번호
        규칙
        1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말해
        2. 마지막 사람이 단어를 말한 다음에는 다시 1번
        3. 앞사람이 말한 단어 마지막 문자로 시작하는 단어
        4. 중복 사용 불가능
        5. 한글자는 x
        - 한글자 or 중복 or 마지막 문자와 다른 시작 단어
 */
public class 영어끝말잇기 {

    private static int[] getWordPlay(int n, String[] words){

        int person_index  = 1;
        int count = 0;
        Set<String> set = new HashSet<>();

        //한글자 or 중복 or 마지막 문자와 다른 시작 단어
        String pre_word = words[0];
        for(int i = 1; i < words.length ; i++){
            set.add(pre_word);
            count = i / n + 1;
            int num =  (person_index + 1) % (n + 1);
            person_index = num  == 0 ? 1 : num;

            //System.out.println(person_index + " " + count);
            String word = words[i];

            //다른 단어 시작
            if(pre_word.charAt(pre_word.length() - 1) != word.charAt(0)){
                return new int[]{person_index, count};
                //한글자
            }else if(word.length() == 1){
                return new int[]{person_index, count};
                //중복 체크
            }else if(set.contains(word)){
                return new int[]{person_index, count};
            }else{
                pre_word = word;
            }
        }

        return new int[]{0,0};
    }

    public int[] solution(int n, String[] words) {

        return getWordPlay(n,words);
    }
}
