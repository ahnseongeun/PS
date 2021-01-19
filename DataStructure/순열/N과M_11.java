package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
같은 수를 여러 번 골라도 된다.
중복 수열 출력 x

4 2
9 7 9 1

1 1
1 7
1 9
7 1
7 7
7 9
9 1
9 7
9 9
자기 자신의 중복된 값은 허용하지만 출력에서 중복된 것은 허용하지 않는 경우
 */
public class N과M_11 {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static StringBuilder sb;


    private static void permutation(int index) {

        if(m+1 == index){
            for(int i = 1;i < index; i++)
                sb.append(result[i]+" ");
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i = 1; i <= n;i++){
            if(arr[i] ==  before)
                continue;
            before = arr[i];
            result[index] = arr[i];
            permutation(index+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        result = new int[n+1];
        st = new StringTokenizer(input.readLine());
        for(int i=1;i<=n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        Arrays.sort(arr);
        permutation(1);
        System.out.println(sb);
    }
}
