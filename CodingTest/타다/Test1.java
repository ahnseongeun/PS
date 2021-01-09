package CodingTest.타다;

import java.lang.reflect.Array;
import java.util.*;

/*
n	nationality	result
4	[[1,2],[2,3],[1,3]]	3
5	[[1,2],[2,3]]	7
 */
class Test1 {
    public int solution1(int n,int[][] nationality){
        int countryCount=1;
        ArrayList<Integer> totalCount=new ArrayList<>();
        HashMap<Integer, Set<Integer>> map=new HashMap<>();
        boolean[] studentCount=new boolean[n+1];
        studentCount[0]=true;
            for(int j=0;j<nationality.length;j++){
                int element1=nationality[j][0];
                int element2=nationality[j][1];
                if(map.isEmpty()){
                    Set<Integer> set=new HashSet<>();
                    set.add(element1);
                    set.add(element2);
                    studentCount[element1]= true;
                    studentCount[element2]= true;
                    map.put(countryCount++,set);
                    continue;
                }else{
                    boolean flag=false;
                    for(Integer key:map.keySet()){
                        if(map.get(key).contains(element1)||map.get(key).contains(element2)){
                            Set<Integer> tempSet=map.get(key);
                            tempSet.add(element1);
                            tempSet.add(element2);
                            studentCount[element1]= true;
                            studentCount[element2]= true;
                            map.put(key,tempSet);
                            flag=true;
                            break;
                        }
                    }
                    if(!flag) {
                        map.put(countryCount++, new HashSet<>(element1));
                        map.put(countryCount++, new HashSet<>(element2));
                        studentCount[element1]= true;
                        studentCount[element2]= true;
                    }
                }
            }
        System.out.println(map.get(1));
        for(Integer key: map.keySet())
            totalCount.add(map.get(key).size());
        for(boolean count:studentCount)
            if(count==false)
                totalCount.add(1);
        //비어 있을 경우 0곱하는 경우 예외 처리하기
        int result=0;
        if(totalCount.size()==1){
            result=0;
        }else{
            for(int i=0;i<totalCount.size();i++){
                for(int j=i+1;j<totalCount.size();j++)
                    result+=(totalCount.get(i)*totalCount.get(j));
            }
        }
        return result;
    }
}
