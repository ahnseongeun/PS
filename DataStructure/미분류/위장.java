package DataStructure.미분류;

import java.util.HashMap;

class 위장 {

	/*
	 * 종류별로 같은 이름의 옷은 없으므로 HashMap<종류(String),등장횟수(Integer)>을 이용하여 풀어보았습니다. 처음 등장하는
	 * Key는 등장 횟수를 1로 설정하고, 그 이후 등장 부터는 기존 값에 1을 더하는 방식으로 구현하였습니다. 입을 수 있는 옷 종류의 수는
	 * 각 종류별로 선택할지 안 할지 여부(+1)를 포함하여 아래와 같은 방식으로 구할 수 있습니다. (A종류 옷 가지수 + 1)*(B종류 옷
	 * 가지수 + 1)*(C종류 옷 가지수 + 1) - 1 마지막의 -1은 아무것도 선택하지 않은 경우는 없어야하므로 제외 해준 것입니다.
	 */
// oooaaatt -> o가 포함이 안될수도 있다는 것을 인지하고 -> oooxaaaxttx 이렇게 생각해야하고 xxx인경우를 빼야하기 때문에 -1
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<clothes.length;i++) { //value의 크기를 구할수 있다.
			map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
		}
		int answer = 1;
        for (int value : map.values()) {
            answer*=(value+1);
        }
        answer-=1;
        return answer;
    }
}
