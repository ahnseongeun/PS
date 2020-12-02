package DataStructure.미분류;

import java.util.LinkedList;
import java.util.Queue;

class 단어변환 {
	  static boolean visited[];
	  public int solution(String begin, String target, String[] words) {
		  	Queue<String> q=new LinkedList<String>();
		  	Queue<Integer> level=new LinkedList<Integer>();
		  	visited=new boolean[words.length];
		  	int result=0;
		  	int cnt=0;
		  	q.add(begin);
		  	level.add(cnt);
		  	while(!q.isEmpty()) {
		  		String name=q.poll();
		  		cnt=level.poll();
		  		if(name==target) {
		  			result=cnt;
		  			break;
		  		}
		  		for(int j=0;j<words.length;j++) {
		  			int count=0;
		  			String str=words[j];
		  			for(int i=0;i<str.length();i++) 
		  			{
		  				if(name.charAt(i)!=str.charAt(i))
		  					count++;
		  			}
		  			if(count==1)
		  			{
		  				if(visited[j]==true)
		  					continue;
		  					visited[j]=true;
		  					q.add(str);
		  					level.add(++cnt);
		  			}
		  		}
		  	}
		  	System.out.println(result);
	        int answer = result;
	        System.out.println(answer);
	        return answer;
	    }
}
