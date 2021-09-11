//package CodingTest.카카오;
//
//import java.util.HashMap;
//
//public class Test1 {
//    public static void main(String[] args) {
//
//
//                int[] answer = new int[id_list.length];
//                check = new boolean[1001][1001];
//                HashMap<String, Integer> map = new HashMap<>();
//                HashMap<String, Integer> name_list = new HashMap<>();
//                for(int i = 0; i < id_list.length; i++) {
//                    name_list.put(id_list[i], i);
//                }
//                for(int i = 0; i < report.length; i++) {
//                    String[] command = report[i].split(" ");
//                    int s = name_list.get(command[0]);
//                    int e = name_list.get(command[1]);
//                    if(check[s][e]) continue;
//                    check[s][e] = true;
//                    map.put(command[1],map.getOrDefault(command[1],0) + 1);
//                }
//
//                for(String key :  map.keySet()) {
//                    int cnt = map.get(key);
//                    int idx = name_list.get(key);
//                    if(cnt >= k) {
//                        for(int i = 0; i <= 1000; i++) {
//                            if(check[i][idx]) answer[i]++;
//                        }
//                    }
//                }
//
//                return answer;
//    }
//}
