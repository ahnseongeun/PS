package DataStructure.미분류;

class 네트워크 {
	 static boolean visited[];
	 static int dfs(int[][] computers, int idx) {
		 	if(idx==computers.length)
		 		return 1;
		 	for(int i=0;i<computers.length;i++) {
		 		if(computers[idx][i]==1&&visited[i]==false)
		 		{
		 			visited[i]=true;
		 			dfs(computers,i); 
		 		}
		 	}
			return 1;
	 }
	 public int solution(int n, int[][] computers) {
		 	visited = new boolean[n];
		 	int cnt=0;
		 	for(int i=0;i<n;i++) 
		 	{
		 		if(visited[i]==true)
		 			continue;
		 		 visited[i]=true;
		 		cnt+=dfs(computers,i); //0,0
		 	}
		 	System.out.println(cnt);
	        int answer = cnt;
	        return answer;
	    }
}
