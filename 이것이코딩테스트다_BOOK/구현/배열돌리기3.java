package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/16935
//n m 수행연산번호

6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1
 */
public class 배열돌리기3 {
    private static void display(int arr[][]){
        StringBuilder sb=new StringBuilder();
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    //상하 반전
    private static int[][] upDownTurn(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=arr[n-1-i][j];
            }
        }
        return temp;
    }

    //좌우 반전
    private static int[][] leftRightTurn(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=arr[i][m-1-j];
            }
        }
        return temp;
    }

    //오른쪽 90도 돌리기
    private static int[][] turnRight(int[][] arr) {
        //n=6, m=8
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[m][n];
        for(int i=0;i<n;i++){ //6
            for(int j=0;j<m;j++){ //8
                temp[j][n-i-1]=arr[i][j]; //n,m
            }
        }
        return temp;
    }

    //왼쪽 90도 돌리기
    private static int[][] turnLeft(int[][] arr) {
        //n=6,m=8
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[m-j-1][i]=arr[i][j];
            }
        }
        return temp;
    }

    //큰배열 4등분 후 오른쪽으로 돌리기
    private static int[][] subArrayTurnRight(int[][] arr) {
        //n=6, m=8
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i<n/2&&j<m/2){ //1영역
                    temp[i][j+m/2]=arr[i][j];
                }else if(j>=m/2&&i<n/2){ //2영역
                    temp[i+n/2][j]=arr[i][j];
                }else if(i>=n/2&&j>=m/2){ //4영역
                    temp[i][j-m/2]=arr[i][j];
                }else{ //3영역
                    temp[i-n/2][j]=arr[i][j];
                }
            }
        }
        return temp;
    }

    //큰배열 4등분 후 왼쪽으로 돌리기
    private static int[][] subArrayTurnLeft(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int temp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i<n/2&&j<m/2){ //1영역
                    temp[i+n/2][j]=arr[i][j];
                }else if(j>=m/2&&i<n/2){ //2영역
                    temp[i][j-m/2]=arr[i][j];
                }else if(i>=n/2&&j>=m/2){ //4영역
                    temp[i-n/2][j]=arr[i][j];
                }else{ //3영역
                    temp[i][j+m/2]=arr[i][j];
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int caseCount=Integer.parseInt(st.nextToken());
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(input.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(input.readLine());
        for(int i=0;i<caseCount;i++){
            int caseNumber=Integer.parseInt(st.nextToken());
            switch (caseNumber){
                case 1:
                    //System.out.println("상하반전");
                    arr=upDownTurn(arr);
                    break;
                case 2:
                    //System.out.println("좌우반전");
                    arr=leftRightTurn(arr);
                    break;
                case 3:
                    //System.out.println("시계방향 90도");
                    arr=turnRight(arr);
                    break;
                case 4:
                    //System.out.println("반시계방향 90도");
                    arr=turnLeft(arr);
                    break;
                case 5:
//                System.out.println("1번 그룹의 부분 배열을 " +
//                        "2번 그룹 위치로, 2번을 3번으로, " +
//                        "3번을 4번으로, " +
//                        "4번을 1번으로 이동시키는 연산");
                    arr=subArrayTurnRight(arr);
                    break;
                case 6:
//                System.out.println("1번 그룹의 부분 배열을 4번 그룹 위치로, " +
//                        "4번을 3번으로, 3번을 2번으로, " +
//                        "2번을 1번으로 이동시키는 연산이다.");
                    arr=subArrayTurnLeft(arr);
                    break;
            }
            if(i==caseCount-1)
                display(arr);
        }
    }
}
