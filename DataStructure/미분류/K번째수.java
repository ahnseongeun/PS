package DataStructure.미분류;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		
		int[] result=new int[commands.length]; //결과 값
		int count=0;
		for(int[] a:commands) {
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int b:array)
				list.add(b);
			int i=a[0];
			int j=a[1];
			int k=a[2];
			List<Integer> list1=list.subList(i-1, j);
			Collections.sort(list1);
			result[count++]=list1.get(k-1);
		}
        return result;
    }

}
