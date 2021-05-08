package CodingTest.카카오2021;

import java.util.Stack;

class Test3 {
    private static boolean check[];
    public String solution(int n, int k, String[] cmd) {
        check = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        //"D 2","C","U 3","C","D 4","C","U 2","Z","Z"
        int idx = n;
        for(int i = 0; i < cmd.length; i++){
            String command = cmd[i];
            char ch = command.charAt(0);
            if(ch == 'D'){ //아래로
                int cnt = command.charAt(2) - '0';
                k = ((k + cnt) % idx);
            }else if(ch == 'U'){ // 위로
                int cnt = command.charAt(2) - '0';
                k = ((k - cnt + idx) % (idx));
            }else if(ch == 'C'){ // 삭제
                check[k] = true;
                stack.add(k);
                if(check[k])
                    k++;
                idx--;
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
