package DataStructure.미분류;

import java.util.HashSet;


class 소수찾기 {
	 static boolean visited[];
	 static char arr[];
	 static char result[];
	 static HashSet<Integer> set=new HashSet<Integer>(); 
	 public static void dfs(int cnt) {
		 if(cnt==visited.length) {
			 return;
		 }
		 for(int i=0;i<visited.length;i++) {
			 if(visited[i]==true) continue;
			 visited[i]=true;
			 result[cnt]=arr[i];
			 int number=0;
			 int len=cnt;
			 for(char a:result) {
				 if(len<0)
					 continue;
				 number+=(a-'0')*(Math.pow(10,len--));
			 }
			 set.add(number);
			 dfs(cnt+1);
			 visited[i]=false;
		 }
		 
		  
	 }
	 public int solution(String numbers) {
		 	int len=numbers.length();
		 	arr=new char[len];
		 	result=new char[len];
		 	visited=new boolean[len];
		 	for(int i=0;i<len;i++) { 
		 		arr[i]=numbers.charAt(i);
		 	}
		 	dfs(0);
		 	int count=0;
		 	for(int num:set) {
		 		System.out.println(num);
		 		if(num==2||num==3||num==5||num==7) {
		 			count++;
		 			continue;
		 		}
		 		for(int i=2;i<=(int)Math.sqrt(num);i++) {
		 			if(num%i==0) { //나눠지면 소수가 아니다.
		 				break;
		 			}
		 			if(i==(int)Math.sqrt(num))
		 				count++;
		 		}
		 	}
			return count;

	    }
}
