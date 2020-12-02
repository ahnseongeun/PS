package DataStructure.미분류;

import java.util.ArrayList;


public class 수식최대화 {
		static boolean visited[]=new boolean[3];
		static char operand[]={'*','+','-'};
		static ArrayList<Long> list1;
		static ArrayList<Character> op1;
		static long result=0;
		static void dfs(int index,char oper[]){
			if(index==3){
				ArrayList<Long> list=new ArrayList<Long>();
				ArrayList<Character> op=new ArrayList<Character>();
				list.addAll(list1);
				op.addAll(op1);
				long sum=-1;
				for(int i=0;i<3;i++){ //+,-,* 계산
					int size=op.size(); //연산의 총계수
					for(int j=0;j<size;j++){
						if(oper[i]==op.get(j)){
							if(oper[i]=='*'){
								op.remove(j);
								size--;
								long a=list.get(j)*list.get(j+1);
								list.remove(j);
								list.remove(j);
								list.add(j, a);
								j--;
							}else if(oper[i]=='+'){
								op.remove(j);
								size--;
								long a=list.get(j)+list.get(j+1);
								list.remove(j);
								list.remove(j);
								list.add(j, a);
								j--;
							}else{
								op.remove(j);
								size--;
								long a=list.get(j)-list.get(j+1);
								list.remove(j);
								list.remove(j);
								list.add(j, a);
								j--;
							}
						}
					}
				}
				//System.out.println(list.toString());
				result=Math.max(Math.abs(list.get(0)), result);
			}
			for(int i=0;i<3;i++){
				if(visited[i]==true)
					continue;
				visited[i]=true;
				oper[index]=operand[i];
				dfs(index+1,oper);
				visited[i]=false;
			}
		}
		
	public static void main(String[] args) {
		list1 =new ArrayList<Long>();
		op1 =new ArrayList<Character>();
		char[] oper=new char[3];
		String str="100-200*300-500+20";
		String st="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='*'||str.charAt(i)=='+'||str.charAt(i)=='-'){
				op1.add(str.charAt(i));
				list1.add(Long.parseLong(st));
				st="";
			}else if(str.length()-1==i){
				st+=str.charAt(i);
				list1.add(Long.parseLong(st));
			}else{
				st+=str.charAt(i);
			}
		}
		dfs(0,oper);
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
