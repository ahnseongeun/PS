package HackerRanker.Day28;

import java.util.*;

public class Day28 {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashMap<String,String> map=new HashMap<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            if(emailID.matches("^[a-z.]+@[gmail]+\\.[com]{2,3}$")
                    &&firstName.matches("^[a-z]{0,20}$")) {
                map.put(emailID, firstName);
                System.out.println(emailID);
            }
        }
        LinkedList<String> list=new LinkedList<>();
        for(String key:map.keySet()){
            list.add(map.get(key));
        }
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        for(String str:list)
            System.out.println(str);
        scanner.close();
    }
}
