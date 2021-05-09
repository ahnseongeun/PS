package CodingTest.카카오2021;

import java.util.Stack;

class Test3 {
    private static boolean check[];


    private int next_k(int k, int operator, int cnt) {
        int idx;
        //+
        if(operator == 0){
            idx = k + cnt;
        //-
        }else{
            idx = k - cnt;
        }
        return idx;
    }

    public String solution(int n, int k, String[] cmd) {
        check = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        //"D 2","C","U 3","C","D 4","C","U 2","Z","Z"
        /**
         * 바로 다음 k를 찾는 것이 관건이다.
         * 다음 원소와 이전 원소?
         * 
         */
        for(int i = 0; i < cmd.length; i++){
            String command = cmd[i];
            char ch = command.charAt(0);
            if(ch == 'D'){ //아래로
                int cnt = command.charAt(2) - '0';
                k = next_k(k, 0 ,cnt);
            }else if(ch == 'U'){ // 위로
                int cnt = command.charAt(2) - '0';
                k = next_k(k, 1 ,cnt);
            }else if(ch == 'C'){ // 삭제
                check[k] = true;
                stack.add(k);
                if(check[k])
                    k++;
            }else{ // 가장 최근에 삭제된 행을 원래되로 복구, 선택 행은 바뀌지 않는다.
                if(!stack.isEmpty())
                    check[stack.pop()] = false;
            }
            System.out.println(k);
        }
        StringBuilder sb = new StringBuilder();
        for(boolean bool : check)
            if(bool)
                sb.append("X");
            else
                sb.append("O");
        return sb.toString();
    }
}
