package DataStructure.미분류;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class 베스트앨범 {
	public int[] solution(String[] genres, int[] plays) {
		
	 	HashMap<String, Integer> map3=new HashMap<String, Integer>();
	 	for(int i=0;i<plays.length;i++) { //HashMap에 장르, 장르에 속한 곡들이 재생된 횟수
	 		if(map3.containsKey(genres[i])) {
	 			map3.replace(genres[i], map3.get(genres[i])+plays[i]);
	 		}else {
	 			map3.put(genres[i], plays[i]);
	 		}
	 	}
	 	List<String> genreList=new ArrayList<String>(map3.keySet());
	 	Collections.sort(genreList, (o1, o2) -> (map3.get(o2).compareTo(map3.get(o1)))); //재생된 횟수에 따른 장르 내림차순
	 	HashMap<Integer, String> map1=new HashMap<Integer, String>(); //장르 HashMap
	 	HashMap<Integer, Integer> map2=new HashMap<Integer, Integer>(); //plays HashMap
	 	for(int i=0;i<plays.length;i++) {
	 		map1.put(i, genres[i]);
	 		map2.put(i, plays[i]);
	 	}
	 	//장르별 내림차순만 있으면 되네
	 	int count2=0;
        //int[] result=new int[genreList.size()*2];
	 	ArrayList<Integer> list=new ArrayList<Integer>();
	 	List<Integer> keysetList=new ArrayList<Integer>(map2.keySet());
	 	Collections.sort(keysetList, (o1, o2) -> (map2.get(o2).compareTo(map2.get(o1)))); //key값 내림차순 정리
	 	for(int i=0;i<genreList.size();i++) {
	 		String test=genreList.get(i);
	 		count2=0;
	 		for(int j:keysetList) {
                 //System.out.println(j);
	 			if(test.equals(map1.get(j))) {
	 				count2++;
	 				list.add(j);
	 				if(count2==2)
	 					break;
            
	 			}
	 		}
	 	}
	 	int[] result=new int[list.size()];
	 	int count=0;
	 	for(int i:list) {
	 		result[count++]=i;
	 	}
		
        return result;
	}
}
