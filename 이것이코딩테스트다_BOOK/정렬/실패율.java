package 이것이코딩테스트다_BOOK.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//0.0/0.0 -> NAN -> 그래서 분자와 분모가 0.0일때를 확인해줘야 한다.
public class 실패율 {
    private static HashMap<Integer,Double> CalculationFailure(int[] stages, double totalSize, int n) {
        HashMap<Integer,Double> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            double userCount=0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]==i)
                    userCount++;
            }
            if(userCount==0&&totalSize==0)
                map.put(i, 0.0);
            else
                map.put(i, userCount/totalSize);
            if(userCount!=0)
                totalSize-=userCount;
        }
        return map;
    }

    private static int[] FailureSort(HashMap<Integer, Double> map) {
        ArrayList<Integer> result=new ArrayList<>(map.keySet());
        Collections.sort(result,(o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int arr[]=new int[result.size()];
        int cnt=0;
        for(Integer temp:result){
            arr[cnt++]=temp;
        }
        return arr;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(input.readLine());
        int stages[]= {2, 1, 2, 6, 2, 4, 3, 3};
        double totalSize= stages.length;
        Arrays.sort(stages);
        HashMap<Integer,Double> map= CalculationFailure(stages,totalSize,n);
        int result[]=FailureSort(map);
        for(int var:result)
            System.out.println(var);
        //return FailureSort(map);
    }
}
