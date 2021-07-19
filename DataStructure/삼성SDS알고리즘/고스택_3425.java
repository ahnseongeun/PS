package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 *
 */
/*
DUP
MUL
NUM 2
ADD
END
3
1
10
50

NUM 1
NUM 1
ADD
END
2
42
43

NUM 600000000
ADD
END
3
0
600000000
1

QUIT
 */
public class 고스택_3425 {

    static public class Object {
        private String command;
        private int num;

        public Object (String command, int num){
            this.command = command;
            this.num = num;
        }

        public Object (String command){
            this.command = command;
        }

        public int getNum() {
            return num;
        }

        public String getCommand() {
            return command;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Queue<Object> q = new LinkedList<>();
        while(true) {

            String command = input.readLine();
            if( command.equals("QUIT")) break;
            if( command.equals("\n")) {
                q = new LinkedList<>();
                continue;
            }
            if( command.startsWith("NUM")) {
                q.add(new Object(command.substring(0,3),Integer.parseInt(command.substring(4))));
            }
            if( !command.equals("END")) q.add(new Object(command));
            if( command.equals("END")) {
                int n = Integer.parseInt(input.readLine());

                for(int i = 0; i < n; i++ ) {
                    boolean check = true;
                    int number = Integer.parseInt(input.readLine());
                    stack = new Stack<>();
                    stack.push(number);
                    for(Object object : q) {
                        String cmd = object.getCommand();
                        if(cmd.equals("NUM")) {
                            int num = object.getNum();
                            stack.push(num);
                        }
                        if(cmd.equals("POP") && !stack.isEmpty()) stack.pop();
                        if(cmd.equals("INV") && !stack.isEmpty()) stack.push(-stack.pop());
                        if(cmd.equals("DUP") && !stack.isEmpty()) stack.push(stack.peek());
                        if(cmd.equals("SWP")) swap(stack);
                        if(cmd.equals("ADD")) check = add(stack);
                        if(cmd.equals("SUB")) sub(stack);
                        if(cmd.equals("MUL")) mul(stack);
                        //if(cmd.equals("DIV")) div(stack);
                        //if(cmd.equals("MOD")) mod(stack);

                    }
                    if(stack.size() == 1 && check) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append("ERROR").append("\n");
                    }
                }
                sb.append("\n");
            }

        }

        System.out.println(sb);
    }

    private static void mul(Stack<Integer> stack) {

        int sum = 1;
        for(int i = 0; i < 2; i++)
            if(!stack.isEmpty())
                sum *= stack.pop();
        stack.push(sum);

    }

    private static void sub(Stack<Integer> stack) {

        int num1 = -1000000000;
        int num2 = -1000000000;
        if(!stack.isEmpty()) {
            num1 = stack.pop();
        }

        if(!stack.isEmpty()) {
            num2 = stack.pop();
        }

        if(num1 != -1000000000 && num2 != -1000000000) stack.push(num2 - num1);

    }

    private static void swap(Stack<Integer> stack) {

        int num1 = -1000000000;
        int num2 = -1000000000;
        if(!stack.isEmpty()) {
            num1 = stack.pop();
        }

        if(!stack.isEmpty()) {
            num2 = stack.pop();
        }

        if(num2 != -1000000000) stack.push(num2);
        if(num1 != -1000000000) stack.push(num1);

    }

    private static boolean add(Stack<Integer> stack) {
        int sum = 0;
        for(int i = 0; i < 2; i++)
            if(!stack.isEmpty())
                sum += stack.pop();
       if(sum > 1000000000) return false;
        stack.push(sum);
        return true;
    }

}
