package DataStructure.미분류;

class 타켓넘버 {
	static int count=0;
	static int target1=0;
	static void dfs(int[] numbers,int index,int sum) {
		if(numbers.length==index) {
			if(sum==target1)
				count++;
			return;
		}
				sum+=numbers[index];
				dfs(numbers,index+1,sum);
				sum-=numbers[index];
				sum+= (-numbers[index]);
				dfs(numbers,index+1,sum);
				sum-= (-numbers[index]);	
	}
	
	 public int solution(int[] numbers,int target) {
		 	target1=target;
		 	dfs(numbers,0,0);
	        int answer = count;
	        return answer;
	    }
}
