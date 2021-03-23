package CodingTest.라인;

import java.util.Arrays;
import java.util.HashMap;

public class Test6 {
    public static void main(String[] args){
        String program = "bank";
        String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
        String[] command = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};
        boolean answer[] = new boolean[command.length];
        Arrays.fill(answer,true);

        // flag_rules 정의
        HashMap<String,String> flag_rule = new HashMap<>();
        String original = null;
        String alias = null;
        for(int i = 0; i < flag_rules.length ; i++) {
            String rule[] = flag_rules[i].split(" ");
            if(rule.length == 2){
                flag_rule.put(rule[0],rule[1]);
            }else{
                original = rule[0];
                alias = rule[2];
            }
        }
        if(flag_rule.get(original) == null){
            flag_rule.put(original,flag_rule.get(alias));
        }else{
            flag_rule.put(alias,flag_rule.get(original));
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
            boolean flag = false;
            for(int j = 1; j < cmdSplit.length; j++){

                //해당 flag_name이 비었다.
                if(cmdSplit[j].equals(original) || cmdSplit[j].equals(alias)){
                    if(flag){
                        answer[i] = false;
                        continue;
                    }else{
                        flag = true;
                    }
                }

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
                        continue;
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
                    continue;
                }else if(rule.equals("NUMBER")){
                    for(int c = 0; c < str.length(); c++){
                        if(str.charAt(c) >= '0' && str.charAt(c) <= '9')
                            continue;
                        answer[i] = false;
                        break;
                    }
                    continue;
                }

                while(j <= cmdSplit.length - 1 && flag_rule.get(cmdSplit[j]) == null){
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
                        continue;
                    }
                    j++;
                }

            }
        }
        for(boolean ans : answer)
            System.out.println(ans);
    }
}
