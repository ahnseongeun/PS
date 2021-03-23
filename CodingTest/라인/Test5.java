package CodingTest.라인;

import java.util.Arrays;
import java.util.HashMap;

public class Test5 {
    public static void main(String[] args){

        String program = "trip";
        String[] flag_rules = {"-days NUMBERS", "-dest STRING"};
        String[] command = {"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"};
        boolean answer[] = new boolean[command.length];
        Arrays.fill(answer,true);

        // flag_rules 정의
        HashMap<String,String> flag_rule = new HashMap<>();
        for(int i = 0; i < flag_rules.length ; i++) {
            String rule[] = flag_rules[i].split(" ");
            flag_rule.put(rule[0],rule[1]);
        }

        for(int i = 0 ; i < command.length; i++){

            String cmd = command[i];
            String[] cmdSplit = cmd.split(" ");

            //프로그램 명이 일치하는지
            if(!cmdSplit[0].equals(program)) {
                answer[i] = false;
                continue;
            }

            //flag_argument 비교
            for(int j = 1; j < cmdSplit.length; j++){

                //해당 flag_name이 비었다.
                String rule = flag_rule.get(cmdSplit[j]);
                if(rule == null) {
                    answer[i] = false;
                    continue;
                }


                if(rule.equals("NULL")){
                    if(j == cmdSplit.length - 1){
                        continue;
                    }else{
                        if(flag_rule.get(cmdSplit[j + 1]) != null){
                            answer[i] = false;
                        }
                    }
                }

                String str = cmdSplit[++j];
                if(rule.equals("STRING")){
                    for(int c = 0; c < str.length(); c++){
                        if(str.charAt(c) >= 'a' && str.charAt(c) <= 'z' || str.charAt(c) >= 'A' && str.charAt(c) <= 'Z')
                            continue;
                        answer[i] = false;
                        break;
                    }
                }else if(rule.equals("NUMBER")){
                    for(int c = 0; c < str.length(); c++){
                        if(str.charAt(c) >= '0' && str.charAt(c) <= '9')
                            continue;
                        answer[i] = false;
                        break;
                    }
                }

                while(j < cmdSplit.length - 1&& flag_rule.get(cmdSplit[j + 1]) == null){
                    str = cmdSplit[j];
                    if(rule.equals("STRINGS")){
                        for(int c = 0; c < str.length(); c++){
                            if(str.charAt(c) >= 'a' && str.charAt(c) <= 'z' || str.charAt(c) >= 'A' && str.charAt(c) <= 'Z')
                                continue;
                            answer[i] = false;
                            break;
                        }
                    }else if(rule.equals("NUMBERS")){
                        for(int c = 0; c < str.length(); c++){
                            if(str.charAt(c) >= '0' && str.charAt(c) <= '9')
                                continue;
                            answer[i] = false;
                            break;
                        }
                    }else{
                        answer[i] = false;
                    }
                    j++;
                }

            }
        }
        for(boolean ans : answer)
            System.out.println(ans);

    }
}
