//package CodingTest.소마;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class test1 {
//    public static void main(String[] args) throws Exception{
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(input.readLine());
//        int n = st.countTokens();
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i = 0; i < n; i++)
//            map.put(st.nextToken().charAt(0),i);
//        int arr[][] = new int[n][n];
//        int m = Integer.parseInt(st.nextToken());
//        for(int i = 0;i < m; i++){
//            st = new StringTokenizer(input.readLine());
//            arr[map.get(st.nextToken().charAt(0))][]
//        }
//
//    }
//}
