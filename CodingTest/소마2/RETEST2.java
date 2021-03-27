package CodingTest.소마2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
10
3 5 -1 -2 4 4 3 -2 -3 -2
5
3 -1 1 1 -3
5
1 1 1 1 -4
2
1 -1
5
1 -1 1 1 -2
 */
public class RETEST2 {


    private static int[] arr; // 처음 배열
    private static int[] indegree; // 시작 위치를 담은 배열
    private static int[] topo_sorted; // 정렬된 배열
    private static boolean[] visited;
    private static int n;
    private static int sz;

    private static void dfs(int x) {
        visited[x] = true;
        sz++;
        if(visited[x + arr[x]])
            return;
        dfs(x + arr[x]);
    }

    private static void pro() {
        Queue<Integer> q = new LinkedList<>();

        //처음 시작점 q에 넣기
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0)
                q.add(i);

        System.out.println(Arrays.toString(Arrays.stream(indegree).toArray()));

        // 위상 정렬 (순환이 있는 그래프 찾기) -> 0이면 순환 하는 그래프에 포함된다.
        // 가장 앞에 있는 큐의 값을 빼서 sorted 배열에 넣고 ,
        // 그래프에서 x라는 정점이 빠져서 x + arr[x]와 관련된 indegree 하나 줄어들게 하기
        int count = 1;
        while(!q.isEmpty()) {
            int x = q.poll();
            topo_sorted[x] = count++;
            // x라는 정점이 그래프에서 지워지면, x + a[x]의 indegree가 하나 줄어듬
            indegree[x + arr[x]]--;

            // 줄어든 indegree가 0 이 되면 시작 점에 추가
            //그래프에 순회하는 것이 있으면 indegree가 0이 될 수가 없다.
            //System.out.println(Arrays.toString(Arrays.stream(indegree).toArray()));
            if (indegree[x + arr[x]] == 0)
                q.add(x + arr[x]);
        }
        System.out.println(Arrays.toString(Arrays.stream(indegree).toArray()));
        // 갈수 없는 회로는 0 이 아니다.
        System.out.println(Arrays.toString(Arrays.stream(topo_sorted).toArray()));

        //가장 긴 무한 회로 찾기
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(topo_sorted[i] == 0){ //i라는 정점은 무한 회로에 있다!
                if(!visited[i]){
                    sz = 0;
                    dfs(i);
                    ans = Math.max(ans,sz);
                }
            }
        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        arr = new int[n];
        indegree = new int[n];
        topo_sorted = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            indegree[i + arr[i]]++;
        }
        pro();
    }
}


/*
#include <iostream>
#include <algorithm>
typedef long long int ll;
using namespace std;
#define NM 100005

int n, a[NM], indegree[NM];

void input() {
   cin >> n;
   for (int i = 1; i <= n; i++) {
      cin >> a[i];
      // i -> i+a[i]
      indegree[i + a[i]]++;
   }
}
#include <queue>
int topo_sorted[NM], visit[NM], sz;
void dfs(int x) {
   visit[x] = 1;
   sz++;
   if (visit[x + a[x]]) return;
   dfs(x + a[x]);
}
void pro() {
   queue<int> Q;
   for (int i = 1; i <= n; i++) if (indegree[i] == 0) Q.push(i);
   while (!Q.empty()) {
      int x = Q.front(); Q.pop();
      topo_sorted[x] = 1;
      // x라는 정점이 그래프에서 지워지면, x+a[x] 의 indegree가 하나 줄어들게 됩니다.
      indegree[x + a[x]]--;
      if (indegree[x + a[x]] == 0) {
         Q.push(x + a[x]);
      }
   }
   int ans = 0;
   for (int i = 1; i <= n; i++) {
      if (topo_sorted[i] == 0) { // i라는 정점은 무한 회로 위에 있다!
         if (visit[i] == 0) {
            sz = 0;
            dfs(i);
            ans = max(ans, sz);
         }
      }
   }
   cout << ans;
}
int main() {
   ios::sync_with_stdio(false); cin.tie(0);
   input();
   pro();
   return 0;
}
 */