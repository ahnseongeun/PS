package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
3
9
2 1 4 3 5 6 2 7 2
 */

/**
 * 힙에서 중간에 값을 바꿀경우 힙이 제대로 동작하지않을 수있다.
 * 힙은 넣고 뺼때 정렬이 되기 때문이다.
 */
public class 후보추천하기_1713 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        ArrayList<Person> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < m; i++) {

            boolean check = false;

            //인덱스 가져오기
            int idx = Integer.parseInt(st.nextToken());


            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).index == idx) {
                    list.get(j).likeCount++;
                    check = true;
                    break;
                }
            }

            if(!check) {
                if(list.size() == size) {
                    //Comparable은 단지 정렬의 기준이다.
                    Collections.sort(list);
                    list.remove(0);
                    list.add(new Person(idx, 0, i));
                } else  {
                    list.add(new Person(idx, 0, i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        list.sort(Comparator.comparingInt(o -> o.index));
        for(Person person : list) {
            sb.append(person.index).append(" ");
        }
        System.out.println(sb);
    }


    static class Person implements Comparable<Person>{
        private int index;
        private int likeCount;
        private int registerDay;

        public Person(int index, int likeCount, int registerDay) {
            this.index = index;
            this.likeCount = likeCount;
            this.registerDay = registerDay;
        }


        @Override
        public int compareTo(Person o) {
            if(this.likeCount == o.likeCount) return this.registerDay - o.registerDay;
            return this.likeCount - o.likeCount;
        }
    }
}
