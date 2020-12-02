package DataStructure.미분류;

import java.util.LinkedList;
import java.util.Queue;

class 주식가격 {
//	테스트 1 〉	통과 (0.32ms, 52MB)
//	테스트 2 〉	통과 (0.49ms, 52.9MB)
//	테스트 3 〉	통과 (3.47ms, 51.7MB)
//	테스트 4 〉	통과 (2.50ms, 54.2MB)
//	테스트 5 〉	통과 (3.17ms, 53.2MB)
//	테스트 6 〉	통과 (0.38ms, 51.7MB)
//	테스트 7 〉	통과 (2.30ms, 52.5MB)
//	테스트 8 〉	통과 (2.08ms, 52.4MB)
//	테스트 9 〉	통과 (0.44ms, 52.9MB)
//	테스트 10 〉	통과 (2.81ms, 53.2MB)
//	효율성  테스트
//	테스트 1 〉	통과 (66.83ms, 77.3MB)
//	테스트 2 〉	통과 (41.63ms, 70.4MB)
//	테스트 3 〉	통과 (63.31ms, 74.9MB)
//	테스트 4 〉	통과 (62.06ms, 73MB)
//	테스트 5 〉	통과 (37.47ms, 67.1MB)
	 public int[] solution(int[] prices) {
		 int[] answer = new int[prices.length];

	        Queue<Integer> queue = new LinkedList<>();

	        for(int temp : prices) {
	            queue.add(temp);
	        }

	        for(int i=0; i<prices.length; i++) {
	            int x = queue.poll();
	            int second = 0;
	            for(int temp : queue) {
	                if(x <= temp) second++; // 가격이 떨어지지 않으면
	                if(x > temp) { // 가격이 떨어지면
	                    second++;
	                    break;
	                }
	            }
	            answer[i] = second;
	        }

	        return answer;


	    }
}

//for(int i=0;i<prices.length;i++) {s
//	 int count=0;
//	 for(int j=i+1;j<prices.length;j++) {
//		 count++;
//		 if(prices[i]>prices[j]) {
//			 break;
//		 }
//	 }
//	 System.out.println(count);
//}

//정확성  테스트
//테스트 1 〉	통과 (0.01ms, 52.3MB)
//테스트 2 〉	통과 (0.03ms, 51.9MB)
//테스트 3 〉	통과 (0.13ms, 53.3MB)
//테스트 4 〉	통과 (0.21ms, 52.9MB)
//테스트 5 〉	통과 (0.25ms, 53MB)
//테스트 6 〉	통과 (0.02ms, 51.9MB)
//테스트 7 〉	통과 (0.14ms, 52.7MB)
//테스트 8 〉	통과 (0.10ms, 52MB)
//테스트 9 〉	통과 (0.02ms, 53.2MB)
//테스트 10 〉	통과 (0.26ms, 52.7MB)
//효율성  테스트
//테스트 1 〉	통과 (16.53ms, 71.4MB)
//테스트 2 〉	통과 (13.35ms, 65MB)
//테스트 3 〉	통과 (12.99ms, 75MB)
//테스트 4 〉	통과 (13.97ms, 72.2MB)
//테스트 5 〉	통과 (12.86ms, 68MB)

/*
 * Queue<Integer> q=new LinkedList<>(); q.add(1); int start=0; for(int
 * i=0;i<prices.length-1;i++) { if(prices[i]<=prices[i+1]){ //다음 값과 이전값을 비교한다.
 * for(int k=0;k<start;k++) { q.add(q.poll()); } for(int j=start;j<q.size();j++)
 * { q.add(q.poll()+1); } q.add(1); }else { start=i+1; for(int
 * k=0;k<start-1;k++) { q.add(q.poll()+1); } for(int j=start-1;j<q.size();j++) {
 * q.add(q.poll()); }
 * 
 * } } q.add(0); //마지막에 0 append int[] answer =new int[q.size()]; int count=0;
 * for(int a:q) { answer[count++]=a; } return answer;
 */