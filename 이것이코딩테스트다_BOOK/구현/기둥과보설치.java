package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5
{1,0,0,1}
{1,1,1,1}
{2,1,0,1}
{2,2,1,1}
{5,0,0,1}
{5,1,0,1}
{4,2,1,1}
{3,2,1,1}
 */
/*
x,y,a,b
a 0은 기둥, 1은 보
b 0은 삭제, 1은 설치

기둥은 바닥 위에 있거나, 보의 한쪽 끝부분 위에 있거나 다른 기둥 위에 있어야한다.
보는 한쪽 끝부분에 기둥 위에 있거나, 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야한다.
a가 0, b가 0 - 기둥 삭제 / y+1 0으로 교체 /
a가 0, b가 1 - 기둥 설치 / y+1 1로 교체 / y가 바닥 이거나 y의 값이 1일때만 y+1 1로 교체
a가 1, b가 0 - 보 삭제 / x+1 0으로 교체 /
a가 1, b가 1 - 보 설치 / x+1 1로 교체 / x에 기둥이나 보가 있고, x+1에
 */
public class 기둥과보설치 {
    //static int building[][];

    private static void display(int[][] building){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i< building.length;i++){
            for(int j=0;j< building.length;j++)
                sb.append(building[i][j]+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[][] displayResult(ArrayList<int[]> result) {
        int finalList[][]=new int[result.size()][4];
        for(int i=0;i<result.size();i++){
            finalList[i]=result.get(i);
        }
        return finalList;
    }

    private static int getIndex(ArrayList<int[]> result, int[] newBuild_frame) {
        Iterator it = result.iterator();
        int cnt = 0;
        boolean flag=false;
        while(it.hasNext()){
            int tmp[]=(int[])it.next();
            if(Arrays.equals(tmp,newBuild_frame)) {
                flag=true;
                break;
            }
            cnt++;
        }
        return flag ? cnt : -1;
    }

    private static boolean build(ArrayList<int[]> result) {
        for(int i = 0; i < result.size(); i++){
            int buildInfo[] = result.get(i);
            int x = buildInfo[0];
            int y = buildInfo[1];
            int a = buildInfo[2];
            if(a==0){ //기둥 설치 //y-1 기둥 설치,x-1보 설치,x보 설치 확인
                int buildInfo1[]={x,y-1,0};
                int buildInfo2[]={x-1,y,1};
                int buildInfo3[]={x,y,1};
                if(y==0||getIndex(result,buildInfo1)!=-1||getIndex(result,buildInfo2)!=-1||getIndex(result,buildInfo3)!=-1){
                    continue;
                }
                return false;
            }else{ //보 설치  // x,y-1 기둥 설치, x+1,y-1 기둥 설치, x-1과 x+1 보 설치 확인
                int buildInfo1[]={x,y-1,0};
                int buildInfo2[]={x+1,y-1,0};
                int buildInfo3[]={x-1,y,1};
                int buildInfo4[]={x+1,y,1};
                if(getIndex(result,buildInfo2)!=-1||getIndex(result,buildInfo1)!=-1||(getIndex(result,buildInfo3)!=-1&&getIndex(result,buildInfo4)!=-1)){
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        int n=5;
        //building=new int[n+1][n+1];
        //int build_frame[][]={{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int build_frame[][]={{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        ArrayList<int[]> result=new ArrayList<>();

        for(int i=0;i<build_frame.length;i++){
            int b=build_frame[i][3];
            int newBuild_frame[]={build_frame[i][0],build_frame[i][1],build_frame[i][2]};
            if(b==1){ //설치
                result.add(newBuild_frame);
                if(!build(result)){
                    result.remove(result.size()-1);
                }
            }else{ //삭제
                int cnt=getIndex(result,newBuild_frame);
                result.remove(cnt);
                if(!build(result)){
                    result.add(cnt,newBuild_frame);
                }
            }
            //display(building);
        }
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return o1[0]-o2[0];
                }else if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return -1;
                }
            }
        });
        displayResult(result);

    }
}





















