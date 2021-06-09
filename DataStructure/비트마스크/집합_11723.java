package DataStructure.비트마스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1
 */
public class 집합_11723 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int result = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            String command = st.nextToken();

            switch (command){
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    result |= (1 << x - 1);
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    result &= ~(1 << x - 1);
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    if ((result & (1 << x - 1)) > 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "all": {
                    result = ~0;
                    break;
                }
                case "empty": {
                    result = 0;
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    result ^= 1 << (x - 1);
                }
                default:
                    break;
            }

        }
        System.out.println(sb);
    }
}
