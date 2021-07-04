package CodingTest.네이버웹툰;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//한개짜리 String 고려
public class Test2 {

    private static String[] solution(String s) {
        ArrayList<String> result = new ArrayList<>();
        int midIdx = s.length() / 2 - 1;
        int leftStartIdx = 0;
        int leftEndIdx = 1;
        int rightStartIdx = s.length() - 1;
        int rightEndIdx = s.length();
        boolean duplicateCheck = false;
        while(leftStartIdx <= rightStartIdx) {
            if(s.substring(leftStartIdx,leftEndIdx).equals(s.substring(rightStartIdx,rightEndIdx))){
                if(leftStartIdx >= rightStartIdx) duplicateCheck = true;
                //System.out.println(s.substring(leftStartIdx,leftEndIdx) + " " + s.substring(rightStartIdx,rightEndIdx));
                result.add(s.substring(leftStartIdx,leftEndIdx));
                leftStartIdx = leftEndIdx;
                rightEndIdx = rightStartIdx;
            }
            leftEndIdx ++;
            rightStartIdx--;
        }
        String[] answer;
        if(duplicateCheck) answer = new String[result.size() * 2 - 1];
        else answer = new String[result.size() * 2];

        int idx = 0;
        for(String str : result) answer[idx++] = str;
        for(int i = result.size() - 1; i >= 0; i--){
            if(duplicateCheck && i == result.size() - 1) continue;
            answer[idx++] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        String str = "aabbbcaa";
        String[] result = solution(str);
        for(String string : result) System.out.println(string);
    }
}
