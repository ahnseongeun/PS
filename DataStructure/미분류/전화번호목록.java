package DataStructure.미분류;

import java.util.HashMap;

public class 전화번호목록 {
	public boolean solution(String[] phone_book) { //접두사
			boolean answer = true;
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			for(String book:phone_book) {
				map.put(book,1);
			}
			int count=0;
			for(String phone:phone_book) {
				count=0;
				for(int i=0;i<=phone.length();i++) {
					if(map.containsKey(phone.substring(0, i))) { 
						count++;
						if(count==2)
							answer=false;
					}
				}
			}
			return answer;
		}
		// TODO Auto-generated method stub
	}