package CodingTest.큐피스트;

import java.util.ArrayList;
import java.util.List;

/*
    private static int isPresent(Node root, int val){

        if(root == null) return 0;

        Node current = root;
        while(current.data != val){
            if(current.data > val){  // 현재 값이 전달된 값보다 더 크다면
                current = current.left;
            } else {
                current = current.right;
            }

            if(current == null){
                return 0;
            }
        }
        return 1;
    }
     test 1
 */


 /*
 public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {

        System.out.println(a);
        System.out.println(b);
        List<Integer> result = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;
        while(true) {

            if( idx1 == a.size()) {
                while(idx2 != b.size()) {
                    result.add(b.get(idx2++));
                }
                break;
            }
            if( idx2 == b.size()) {
                while(idx1 != a.size()) {
                    result.add(a.get(idx1++));
                }
                break;
            }

            if( a.get(idx1) < b.get(idx2) ) {
                result.add(a.get(idx1++));
            } else if( a.get(idx1) == b.get(idx2) ) {
                if( idx1 < idx2) {
                    result.add(a.get(idx1++));
                } else {
                    result.add(b.get(idx2++));
                }
            } else {
                result.add(b.get(idx2++));
            }
        }
        return result;
    }
    test2
  */


  /*
  public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        // Write your code here
        int result = 0;
        Set<String> set = new HashSet();

        //반례 Price 2 weight 22 , price 22 weight 2 -> + 추가
        for(int i = 0; i < name.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String key = sb.append(name.get(i))
            .append("+")
            .append(price.get(i))
            .append("+")
            .append(weight.get(i)).toString();
            if(!set.add(key)) result++;
        }
        return result;
    }
   */

/*

public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
    // Write your code here

        System.out.println(arr.size());
        List<Integer> reverse_arr = new ArrayList<>();
        int[] reverse_temp = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) reverse_temp[i] = arr.get(i);


        for(List<Integer> operation : operations) {
            int left = operation.get(0);
            int right = operation.get(1);
            Stack<Integer> stack = new Stack<>();
            for(int i = left; i <= right; i++) stack.push(reverse_temp[i]);
            for(int i = left; i <= right; i++) reverse_temp[i] = stack.pop();

        }

        for(int val : reverse_temp) reverse_arr.add(val);
        return reverse_arr;
    }
 */

/*
public static List<Integer> minimalOperations(List<String> words) {
    // Write your code here

        List<Integer> result = new ArrayList<>();

        for(String word : words) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char ch = word.charAt(0);
            for(int i = 1; i < word.length(); i++) {
                if(ch == word.charAt(i)) {
                    count++;
                    ch = (char)(ch - 32);
                    i++;
                }
                if( i < word.length()) ch = word.charAt(i);
            }
            result.add(count);
        }

        return result;
    }
 */
