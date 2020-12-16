package 이것이코딩테스트다_BOOK.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//괴물이 있으면 0, 괴물이 없으면 1

//동빈님의 해결법중 배울점 arr[y+dy][x+dx]에 이전 arr[y][x]의 +1을 해서 최종적으로 arr[y][x]를 출력하면된다.
public class 미로찾기_BFS {
        static int[] dx={0,0,1,-1};//상하좌우
        static int[] dy={1,-1,0,0};//상하좌우
        static int n;
        static int m;
        static int bfs(int arr[][],int x,int y){
            int count=0;
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{x,y,0});
            arr[x][y]=0;
            while(!q.isEmpty()){
                int temp[]=q.poll();
                x=temp[0];
                y=temp[1];
                count=temp[2];
                if(m-1==x&&n-1==y)
                    break;
                for(int i=0;i<4;i++){
                    if(y+dy[i]<0||y+dy[i]>n-1||x+dx[i]<0||x+dx[i]>m-1)
                        continue;
                    if(arr[y+dy[i]][x+dx[i]]==0)
                        continue;
                    arr[y+dy[i]][x+dx[i]]=1;
                    q.add(new int[]{x+dx[i],y+dy[i],count+1});
                }
            }
            return count;
        }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st=new StringTokenizer(input.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            String str=input.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        int count=bfs(arr,0,0);
        System.out.println(count+1);
    }
}
