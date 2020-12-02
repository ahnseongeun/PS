package DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {

	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(input.readLine());
		int n=Integer.parseInt(st.nextToken()); //벨트의 접시 수
		int d=Integer.parseInt(st.nextToken()); //초밥의 가지수
		int k=Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 개수
		int c=Integer.parseInt(st.nextToken()); //쿠폰 번호
		int dish[]=new int[n]; //벨트의 있는 접시 종류
		boolean sushi[]=new boolean[d+1]; //초밥이 있는지 확인하는 용도
		for(int i=0;i<n;i++)
			dish[i]=Integer.parseInt(input.readLine());
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			int count=0;
			Arrays.fill(sushi, false);
			for(int j=i;j<(i+k);j++){
				if(sushi[dish[j%n]]==false){
					sushi[dish[j%n]]=true;
					count++;
				}
			}
			if(!sushi[c])
				count++;
			if(count==k+1) {
				max = count;
				break;
			}
			max=Math.max(max, count);
		}
		System.out.println(max);
		// TODO Auto-generated method stub

	}

}
