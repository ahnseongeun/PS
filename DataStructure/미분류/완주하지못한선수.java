package DataStructure.미분류;

import java.util.HashMap;

class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		String str1="";
		for(String str:completion) {
			map.put(str, map.getOrDefault(str, 0)+1); //있다면 key반환 없다면 새로운 키 지정
		}
		for(String str:participant) {
			if(map.get(str)==null) {
				str1=str;
				break;
			}
			map.put(str, map.get(str)-1);
		}
		if(str1=="") {
			for(String str:completion) {
					if(map.get(str)!=0)
						str1=str;
			}
		}

		return str1;
		}
		// TODO Auto-generated method stub

	
	}


