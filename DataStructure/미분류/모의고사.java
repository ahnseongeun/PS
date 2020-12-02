package DataStructure.미분류;

import java.util.ArrayList;

class 모의고사 {
	 public int[] solution(int[] answers) {
		 	int[] list1= {1,2,3,4,5};
		 	int[] list2= {2,1,2,3,2,4,2,5};
		 	int[] list3= {3,3,1,1,2,2,4,4,5,5};
		 	int point1=0;int point2=0;int point3=0;
		 	
		 	for(int i=0;i<answers.length;i++) {
		 		if(answers[i]==list1[i%list1.length]) {
		 			point1++;
		 		}
		 		if(answers[i]==list2[i%list2.length]) {
		 			point2++;
		 		}
		 		if(answers[i]==list3[i%list3.length]) {
		 			point3++;
		 		}
		 	}
		 	int max= Math.max(Math.max(point1, point2), point3);
		 	ArrayList<Integer> list=new ArrayList<Integer>();
		 	if(max==point1) list.add(1);
		 	if(max==point2) list.add(2);
		 	if(max==point3) list.add(3);
		 	int answer[]= new int[list.size()];
		 	int count=0;
		 	for(int point:list)
		 		answer[count++]=point;
	        return answer;
	    }
}
