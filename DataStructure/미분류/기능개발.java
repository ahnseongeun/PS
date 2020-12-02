package DataStructure.미분류;

import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
	  public int[] solution(int[] progresses, int[] speeds) {
		  	Queue<int[]> q=new LinkedList<int[]>(); //紐뉖쾲 + 紐뉖쾲��諛고룷�몄�
		  	boolean visit[]=new boolean[progresses.length];
		  	for(int i=0;i<progresses.length;i++)
		  		visit[i]=false;
		  	int point=0;
		  	for(int i=0;i<progresses.length;i++) {
		  		if(progresses[i]>100)
		  			continue;
		  		point=i; //紐뉕컻 諛고룷�좎닔 �덈뒗吏�泥댄겕
		  		System.out.println("point"+point);
		  		while(progresses[point]<100) {
		  			for(int j=0;j<progresses.length;j++) {
						progresses[j]+=speeds[j];
		  			}
	  			}
		  		for(int j=0;j<progresses.length;j++) {
		  			if(progresses[j]>=100&&visit[j]==false) {
		  				q.add(new int[] {j,point});
		  				visit[j]=true;
		  			}
		  		}
		  		
		  	}	
		  		while(!q.isEmpty()) {
		  			int[] arr=q.poll();
		  			System.out.println(arr[0]+" "+arr[1]);
		  		}
		  		int[] answer = {};
		        return answer;
		  		 
		  	}
	  
		  	
}

