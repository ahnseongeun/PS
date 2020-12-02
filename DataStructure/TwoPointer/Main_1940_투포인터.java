package DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//6
//9
//2 7 4 1 5 3
public class Main_1940_투포인터 {

	public static void main(String[] args) throws Exception{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(input.readLine());
		int m= Integer.parseInt(input.readLine());
		int arr[]=new int[n];
		StringTokenizer st=new StringTokenizer(input.readLine());
		for(int i=0;i<n;i++)
			arr[i]= Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int start=0;
		int end=n-1;
		int sum=arr[start]+arr[end];
		int count=0;
		while(true){
			if(start==n-1&&end==0)
				break;
			if(end==0){
				sum-=arr[start];
				start++;
				sum+=arr[start];
				if(sum==m)
					count++;
			}else if(start==n-1){
				sum-=arr[end];
				end--;
				sum+=arr[end];
				if(sum==m)
					count++;
			}else{
				if(sum<m){
					sum-=arr[end];
					end--;
					sum+=arr[end];
				}else if(sum==m){
					count++;
					if(end==0){
						sum-=arr[start];
						start++;
						sum+=arr[start];
					}
					if(start==n-1){
						sum-=arr[end];
						end--;
						sum+=arr[end];
					}
				}else{
					sum-=arr[start];
					start++;
					sum+=arr[start];
				}
			}
			System.out.println(sum);
		}
		System.out.println(start+" "+end);
		System.out.println(count);
		// TODO Auto-generated method stub

	}

}
