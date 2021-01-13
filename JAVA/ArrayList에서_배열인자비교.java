package JAVA;

import java.util.*;

/**
 * int[] a = new int[]{1, 2, 3};
 * int[] b = new int[]{1, 2, 3};
 * System.out.println(a.equals(b)); //prints "false" because a and b refer to different objects
 * System.out.println(Arrays.equals(a, b)); //prints "true" because the elements of a and b have the same values
 */

/**
 int a[] = { 1, 2, 3 };
 int b[] = { 1, 2, 3 };

 Object[] aObject = { a }; // aObject contains one element
 Object[] bObject = { b }; // bObject contains one element

 System.out.println(Arrays.equals(aObject, bObject)); // false
 System.out.println(Arrays.deepEquals(aObject, bObject));// true
 */

public class ArrayList에서_배열인자비교 {
    public static void main(String[] args){
        ArrayList<int[]> list=new ArrayList();
        list.add(new int[]{1,1,0});
        list.add(new int[]{1,2,0});
        list.add(new int[]{1,3,0});
        list.add(new int[]{1,4,0});
        list.add(new int[]{1,5,0});
        int arr[]={1,1,0};
        for(int[] temp:list)
            if(Arrays.equals(temp,arr))
                System.out.println("good");
        /*
        Iterator it= list.iterator();
        int temp[]={1,1,0};
        int count=0;
        boolean flag=false;

        while(it.hasNext()){
            int tmp[]= (int[]) it.next();
            flag=false;
            for(int i=0;i<temp.length;i++){
                if(temp[i]!=tmp[i]){
                    flag=true;
                }
            }
            if(!flag)
                break;
            count++;
        }
        System.out.println(count);
        */

    }
}
