package DataStructure.미분류;

import java.util.Arrays;
import java.util.Comparator;

class 가장큰수 {
	public String solution(int[] numbers) {
		StringBuilder sb=new StringBuilder();
		String[] str=new String[numbers.length];
		int cnt=0;
		for(int num:numbers)
			str[cnt++]=String.valueOf(num);
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		for(String num:str)
			sb.append(num);
		String answer=sb.toString();
		if(answer.startsWith("0"))
			answer="0";
			
		System.out.println(answer);
		return answer;
    }
}
