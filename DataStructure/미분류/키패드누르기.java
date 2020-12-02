package DataStructure.미분류;

import java.util.ArrayList;


public class 키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		ArrayList<int[]> list=new ArrayList<int[]>();
		list.add(new int[]{3,1});
		list.add(new int[]{0,0});
		list.add(new int[]{0,1});
		list.add(new int[]{0,2});
		list.add(new int[]{1,0});
		list.add(new int[]{1,1});
		list.add(new int[]{1,2});
		list.add(new int[]{2,0});
		list.add(new int[]{2,1});
		list.add(new int[]{2,2});
		list.add(new int[]{3,0});
		list.add(new int[]{3,2});
		char[][] phone={{'1','2','3'},
					    {'4','5','6'},
					    {'7','8','9'},
					    {'*','0','#'}};
		String hand = "right";
		int left_cursor[]= list.get(10);
		int right_cursor[]= list.get(11);
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<numbers.length;i++){
			int cursor=numbers[i];
			if(cursor==1||cursor==4||cursor==7){
				left_cursor=list.get(cursor);
				sb.append("L");
			}else if(cursor==3||cursor==6||cursor==9){
				right_cursor=list.get(cursor);
				sb.append("R");
			}else{
				
			}
		}
	}
}
