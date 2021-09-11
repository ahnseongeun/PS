package CodingTest.카카오;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Test3 {

    static int getTime(String time) {
        String[] totalTime = time.split(":");
        int hour = Integer.parseInt(totalTime[0]) * 60;
        int minute = Integer.parseInt(totalTime[1]);
        return hour + minute;
    }

    static int getPrice(int time, int[] fees) {

        int price = fees[1];
        float remindTime = (float)(fees[0] - time);
        if(remindTime >= 0) {
            return price;
        }  else {
            remindTime = Math.abs(remindTime);
            return (int) (price + Math.ceil((remindTime / fees[2])) * fees[3]);
        }
    }

    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] recodes = {"05:34 5961 IN", "06:33 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0000 IN", "18:59 0000 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        TreeSet<String > set = new TreeSet<>();
        for(int i = 0; i < recodes.length; i++) {
            String[] recode = recodes[i].split(" ");
            int time = getTime(recode[0]);
            String number = recode[1];
            set.add(number);
            String command = recode[2];
            if(command.equals("IN")) {
                map.put(number, time);
            } else {
                int startTime = map.get(number);
                map.remove(number);
                int totalTime = time - startTime;
                if(result.get(number) != null) {
                    totalTime += result.get(number);
                }
                result.put(number, totalTime);
            }
        }

        int endTime = 1439;
        for(String number : map.keySet()) {
            int startTime = map.get(number);
            int totalTime = endTime - startTime;
            if(result.get(number) != null) {
                totalTime += result.get(number);
            }
            result.put(number, totalTime);
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for(String key : set) {
            int time = result.get(key);
            answer[idx] = getPrice(time, fees);
            System.out.println(answer[idx]);
            idx++;
        }

        //return answer;
    }
}
