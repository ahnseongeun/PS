package DataStructure.미분류;

import java.util.Arrays;


class H_index {
	public int solution(int[] citations) {
		int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        System.out.println(answer);
        return answer;
    }
//	public int solution(int[] citations) {
//        Arrays.sort(citations);
//
//        int max = 0;
//        for(int i = citations.length-1; i > -1; i--){
//            int min = (int)Math.min(citations[i], citations.length - i);
//            if(max < min) max = min;
//        }
//
//        return max;
//    }
}
