package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. 각 그룹의 앞자리의 0의 전체 또는 일부를 생략 할 수 있다. 위의 IPv6을 축약하면, 다음과 같다
 * 2. 만약 0으로만 이루어져 있는 그룹이 있을 경우 그 중 한 개 이상 연속된 그룹을 하나 골라 콜론 2개(::)로 바꿀 수 있다.
 * - 2번째 규칙은 모호함을 방지하기 위해서 오직 한 번만 사용할 수 있다.
 * -> 올바른 축약형 IPv6주소가 주어졌을 때, 이를 원래 IPv6 (32자리의 16진수)로 복원하는 프로그램을 작성하시오.
 */
/*
25:09:1985:aa:091:4846:374:bb
0025:0009:1985:00aa:0091:4846:0374:00bb
::1
0000:0000:0000:0000:0000:0000:0000:0001
2001:db8:85a3::8a2e:370:7334

1:2:3:4:5:6:7::
::1:2:3:4:5:6:7
 */
public class IPv6_3107 {

    private static StringBuilder sb = new StringBuilder();

    private static int decompression(String ip) {
        int cnt = 0;
        int idx = 0;
        int word_length = 0;
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i < ip.length(); i++){
            char ch = ip.charAt(i);
            if(ch == ':' || i == ip.length() - 1){

                while(word_length < 4){
                    tmp.insert(0,0);
                    word_length++;
                }
                sb.append(tmp).append(ch);
                if(i < ip.length() - 1 && ip.charAt(i + 1) == ':') {
                    idx = sb.length();
                }
                cnt++;
                tmp = new StringBuilder();
                word_length = 0;
            }else{
                tmp.append(ch);
                word_length++;
            }
        }
        StringBuilder temp = new StringBuilder();
        for(int i = cnt; i < 8; i++){
            temp.append("0000:");
        }
        sb.insert(idx,temp.toString());
        return idx;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String ip = input.readLine();
        int idx = decompression(ip + '-');
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        if(idx == 5 && sb.length() > 40){
            result = sb.substring(5);
        }
        if(idx == 35 && sb.length() > 40){
            result = sb.substring(0,39);
        }
        System.out.println(result);

    }
}
