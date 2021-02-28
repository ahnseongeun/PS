package DataStructure.문자열;

/**
 * 특정 문자열 순서를 만족하는 문자열을 문자열 배열에서 찾을 수 있니??
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;
        int skill_length = skill_trees.length;
        int objectSize = skill.length();


        /**
         * 검사 조건이 성립할때 마다 count라는 변수를 이용해서
         * 현재 조건에 만족하는 인덱스와 다르면 break 같으면 계속 진행
         */
        for(int i = 0; i < skill_length; i++){
            String str = skill_trees[i];
            boolean check = false;
            int count = 0;
            for(int j = 0; j < str.length() ; j++){
                char ch = str.charAt(j);
                for(int k = 0; k < objectSize; k++){
                    if(ch == skill.charAt(k)){
                        System.out.println(i+ " " +ch + " " + count);
                        if(k != count){
                            check = true;
                            break;
                        }
                        count++;
                    }
                }
            }
            if(!check)
                answer++;
        }
        return answer;
    }
}

public class 스킬트리 {
    public static void main(String[] args){
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        Solution solution = new Solution();
        int result = solution.solution(skill,skill_trees);
        System.out.println(result);
    }
}
