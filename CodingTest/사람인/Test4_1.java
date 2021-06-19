package CodingTest.사람인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

//Deeper neural networks are more difficult to train. We present a residual learning framework to ease the training of networks that are substantially deeper than those used previously.[ a ] We explicitly reformulate the layers as learning residual functions with reference to the layer inputs, instead of learning unreferenced functions.[ b, a ] We provide comprehensive empirical evidence showing that these residual networks are easier to optimize, and can gain accuracy from considerably increased depth. [ some_book_b ]
public class Test4_1 {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");
        HashMap<String,Integer> dictionary = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        while(st.hasMoreTokens()){
            String text = st.nextToken();
            if(text.contains("[")){
                sb.append(text).append(" ");
                ArrayList<Integer> result = new ArrayList<>();
                while(st.hasMoreTokens()){
                    text = st.nextToken();
                    if(text.equals("]")){
                        break;
                    }
                    if(text.contains(","))
                        text = text.substring(0, text.length() - 1);

                    if(!dictionary.containsKey(text)) dictionary.put(text, count++);

                    result.add(dictionary.get(text));
                }
                Collections.sort(result);

                for(int i = 0; i < result.size() - 1; i++)
                    sb.append(result.get(i)).append(", ");
                sb.append(result.get(result.size() - 1)).append(" ");
            }
            sb.append(text).append(" ");
        }
        System.out.println(sb);
    }
}
