package DataStructure.진행중인문제;

import java.util.*;

/*
음악의 제목을 구하자.
음악 제목, 재생이 시작되고 끝난 시각, 악보
C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개의 음
음악이 00:00를 넘겨서까지 재생되는 일은 없다.
조건이 일치한다면 제일 긴 음악 제목을 반환한다. -> 시간도 같다면 먼저 입력된 음악 제목 반환
아무것도 조건에 일치하지 않는다면 (None)를 반환한다.

각 음은 1분에 1개씩 재생된다.
음악 길이 < 재생 길이 -> 반복재생

result 배열에 결과들을 담고 조건에 맞게 sort
rusult 배열이 비어있다면 (None)를 반환한다.
*/

/**
 * 이 문제를 푸는 방식은 #이 들어 간것을 치환해주는 방식으로 하면 쉽게 해결 할 수 있다.
 * 내가 놓친 부분은 시간을 다루는 부분인데.
 * end_hour - start_hour를 하고
 * end_min - start_min + (end_hour - start_hour * 60)을 해주면 경우에 따라 상관없이 구할 수 있다.
 */
class 방금그곡_프로그래머스 {

    private static String getMusicName(String m, String[] musicinfos){

        int max = 0;
        String result = "(None)";

        m = m.replaceAll("A#","a")
                .replaceAll("D#","d")
                .replaceAll("C#","c")
                .replaceAll("F#","f")
                .replaceAll("G#","g")
                .replaceAll("E#","e");

        for(int j = 0; j < musicinfos.length; j++){
            String[] strArr = musicinfos[j].split(",");

            String startTime[] = strArr[0].split(":");
            int start_hour = Integer.parseInt(startTime[0]);
            int start_min = Integer.parseInt(startTime[1]);

            String endTime[] = strArr[1].split(":");
            int end_hour = Integer.parseInt(endTime[0]);
            int end_min = Integer.parseInt(endTime[1]);

            String title = strArr[2];
            String melody = strArr[3]
                    .replaceAll("A#","a")
                    .replaceAll("D#","d")
                    .replaceAll("C#","c")
                    .replaceAll("F#","f")
                    .replaceAll("G#","g")
                    .replaceAll("E#","e");


            //시간 구하는 방법
            int hour = end_hour - start_hour;
            int minute = hour * 60 + (end_min - start_min);
            int len = hour + minute;
            StringBuilder str = new StringBuilder();

            for(int i = 0; i < len; i++){
                str.append(melody.charAt(i % melody.length()));
            }

            if(str.toString().contains(m)){
                if(max < len){
                    max = len;
                    result = title;
                }
            }
        }
        return result;
    }

    public String solution(String m, String[] musicinfos) {
        return getMusicName(m, musicinfos);
    }
}