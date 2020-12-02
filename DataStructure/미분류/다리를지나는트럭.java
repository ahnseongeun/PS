package DataStructure.미분류;

import java.util.LinkedList;
import java.util.Queue;

class 다리를지나는트럭 {
     public int solution(int bridge_length, int weight, int[] truck_weights) {
//    	 int bridge_length = 2;
// 		int weight= 10;
// 		int[] truck_weights = {7,4,5,6};
           int time=0; //시간 흐른 것
           int point=0; //현재 트럭무게
           int total_weight=0;
           Queue<int[]> q=new LinkedList<int[]>(); //현재 다리를 지나고 있는 트럭을 표시
           q.add(new int[] {point++,1});
           total_weight+=truck_weights[0];
           while(!q.isEmpty()) { //트럭이 존재 안할때 까지 계속
        	   for(int i=0;i<q.size();i++) { //다리를 건너 트럭 표시
        		   int arr[]=new int[2];
        		   arr=q.poll();
        		   System.out.println(arr[0]+" "+arr[1]+" "+total_weight+" "+point);
        		   if(bridge_length<arr[1]) { //다리의 길이보다 시간이 소요됬다면
        			   //if(truck_weights[arr[0]]<truck_weights.length)
        			   total_weight-=truck_weights[arr[0]];
        		   }else { 
        			   q.add(new int[] {arr[0],arr[1]+1});
        		   }
        	   }
        	   
        	   if(point!=truck_weights.length&&weight>=total_weight+truck_weights[point]) {
        		   total_weight+=truck_weights[point];
        		   q.add(new int[] {point,1});
        		   point++;
        		   //System.out.println(total_weight);
        	   }
        	   time++;
           }
           System.out.println("time"+time);
           int answer = 0;
           return answer;
       }      
}
     


////7,4,5,6
//int time=0; //시간 흐른 것
//int point=1; //현재 트럭무게
//int total_weight=0;
//Queue<int[]> q=new LinkedList<int[]>(); //현재 다리를 지나고 있는 트럭을 표시
//	//int bridge_length = 100;
//	//int weight= 100;
//	//int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
//for(int i=0;i<truck_weights.length;i++) {
//	   if(weight>total_weight+truck_weights[i]) {
//		   q.add(new int[]{truck_weights[i],0}); //트럭 무게, 시간
//		   total_weight += truck_weights[i]; //현재 무게
//		   point=i;
//	   }else {
//		   break;
//	   }
//}
//time+=bridge_length;
//for(int i=point;i<truck_weights.length;i++) {
//	   	for(int j=0;j<q.size();j++) { //다리를 지난것이 있는지 확인
//	   		   int a[]=new int[2];
//	   		   a=q.poll();
//			   if(a[1]>bridge_length) {
//				   total_weight-=a[0];
//			   }else {
//				   q.add(new int[] {a[0],a[1]+bridge_length});
//			   }
//		   }
//	 
//	   time+=bridge_length;
//	   for(int j=i;j<truck_weights.length;j++) {
//		   if(weight>=total_weight+truck_weights[j]) {
//			   q.add(new int[] {truck_weights[j],0});
//			   total_weight+=truck_weights[j];
//			   point=j;
//		   }
//	   }
//
//}
//System.out.println("time"+time);
//int answer = 0;
//return answer;