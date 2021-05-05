package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어떻게 접근하는 것이 가장 빠를까?
 * N 과 L을 받고
 * 상, 하, 좌, 우 방향으로 경사로를 놓아서 길을 만들 수 있는 지 검사한다.
 * 필요한 함수
 * 어떻게 접근해야 빠를까??
 * 함수에 direction을 넣어서 표시하는 방법?
 *
 */
/*
5 1
4 6 6 5 5
5 6 6 4 4
6 6 5 4 5
6 6 5 5 6
5 5 5 6 6
 */
public class 경사로_14890 {

    private static int upCount(int[][] arr, int k) {

        /**
         * 경사로를 놓을 때 놓을 수 있는지 검사
         * 높이가 1차이나는지
         * 경사로를 놓을 수 있는 최소 길이를 만족하는지
         */
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            boolean[] visited = new boolean[arr.length];
            boolean flag = false;

            for(int j = 1; j < arr.length; j++){
                
                //높이가 1이상 차이나는지
                if(Math.abs(arr[j][i] - arr[j - 1][i]) > 1)
                    break;
               
                //경사로를 놓을 수 있는지 검사
                if(arr[j][i] < arr[j - 1][i]){
                    if(j + k - 1 >= arr.length) {
                        flag = true;
                        break;
                    }

                    for(int l = j; l < j + k; l++){
                        if(visited[l]) {
                            flag = true;
                            break;
                        }
                        visited[l] = true;
                    }

                }else if(arr[j][i] == arr[j - 1][i]){

                }else{
                    if(j - k < 0) {
                        flag = true;
                        break;
                    }

                    for(int l = j - k; l < j; l++){
                        if(visited[l]) {
                            flag = true;
                            break;
                        }
                        visited[l] = true;
                    }

                }

                if(flag)
                    break;
                if(j == arr.length - 1) {
                    //System.out.println(i);
                    result++;
                }
            }

        }
        return result;
    }


    private static int rightCount(int[][] arr, int k) {
        /**
         * 경사로를 놓을 때 놓을 수 있는지 검사
         * 높이가 1차이나는지
         * 경사로를 놓을 수 있는 최소 길이를 만족하는지
         */
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            boolean[] visited = new boolean[arr.length];
            boolean flag = false;

            for(int j = 1; j < arr.length; j++){

                if(Math.abs(arr[i][j] - arr[i][j - 1]) > 1)
                    break;

                if(arr[i][j] < arr[i][j - 1]){
                    if(j + k - 1 >= arr.length) {
                        flag = true;
                        break;
                    }
                        for(int l = j; l < j + k; l++){
                            if(visited[l]) {
                                flag = true;
                                break;
                            }
                            visited[l] = true;
                        }

                }else if(arr[i][j] == arr[i][j - 1]){

                }else{
                    if(j - k < 0) {
                        flag = true;
                        break;
                    }

                    for(int l = j - k; l < j; l++){
                        if(visited[l]) {
                            flag = true;
                            break;
                        }
                        visited[l] = true;
                    }

                }

                if(flag)
                    break;
                if(j == arr.length - 1) {
                    result++;
                    //System.out.println(i);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][n];

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        result += upCount(arr, k);
        result += rightCount(arr, k);
        System.out.println(result);
    }

}
