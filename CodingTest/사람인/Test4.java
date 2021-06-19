package CodingTest.사람인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Deeper neural networks are more difficult to train. We present a residual learning framework to ease the training of networks that are substantially deeper than those used previously.[ some_paper_a, some_paper_b ] We explicitly reformulate the layers as learning residual functions with reference to the layer inputs, instead of learning unreferenced functions.[ some_book_a, some_paper_a ] We provide comprehensive empirical evidence showing that these residual networks are easier to optimize, and can gain accuracy from considerably increased depth. [ some_book_b ]
 */
public class Test4 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result_text = new StringBuilder();
        String text = input.readLine().trim();
        HashMap<String, Integer> dictionary = new HashMap<>();

        int count = 1;
        for(int i = 0; i < text.length(); i++){

        }

        int idx = 0;
        while(true) {
            int startIdx = text.indexOf("[", idx);
            if(startIdx == -1)
                break;
            int endIdx = text.indexOf("]", startIdx);
            String script = text.substring(startIdx, endIdx - 1);
            String[] words = script.substring(2).split(", ");
            int[] result = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (dictionary.containsKey(word)) {
                    result[i] = dictionary.get(word);
                } else{
                    dictionary.put(word, count++);
                    result[i] = dictionary.get(word);
                }

            }
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for(int i = 0; i < result.length; i++){
                sb.append(result[i]).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(" ]");
            String word = sb.toString();
            text = text.replace(script.substring(2),word.replace("[ ","").replace(" ]",""));
            idx = endIdx + 1 - (script.length() + 2 - word.length());
        }
        result_text.append(text).append("\n");
        HashMap<Integer , String> map = new HashMap<>();
        for(Map.Entry<String,Integer> entry : dictionary.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        for(int i = 1; i < count; i++){
            result_text.append("[").append(i).append("] ").append(map.get(i)).append("\n");
        }
        System.out.println(result_text);

    }
}

/*
text = text.substring(text.indexOf("["));
            String script = text.substring(text.indexOf("["),text.indexOf("]"));
            String[] words = script.split(", ");
            for(String word : words){
                if(dictionary.containsKey(word)){

                }else {
                    dictionary.put(word, count);
                }
            }
            text = text.substring(script.length() + 1);
            System.out.println(text);
 */