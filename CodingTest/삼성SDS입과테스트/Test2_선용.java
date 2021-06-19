package CodingTest.삼성SDS입과테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2_선용 {

    private static int filtering(String target, int idx, String filter, int filterLength) {
        char[] charArray = target.toCharArray();

        for (int i = 0; i < filterLength; i++) {
            if (filter.charAt(i) == '+') {
                if (charArray[i + idx] == '9') {
                    return Integer.parseInt(target);
                } else {
                    charArray[i + idx] = (char) (charArray[i + idx] + 1);
                }
            }
            if (filter.charAt(i) == '-') {
                if (charArray[i + idx] == '0') {
                    return Integer.parseInt(target);
                } else {
                    charArray[i + idx] = (char) (charArray[i + idx] - 1);
                }
            }
        }
        //System.out.println(Integer.parseInt(new String(charArray)));
        return Integer.parseInt(new String(charArray));
    }

    private static int solution(int A, int B, int filterLength, String filter) {

        ArrayList<Integer> visited = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            visited.add(1000000);
        }
        visited.set(A, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);

        StringBuilder sb = new StringBuilder(filter);
        String reverse = sb.reverse().toString();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            String s = String.valueOf(current);

            for (int i = 0; i < s.length() - filterLength + 1; i++) {
                int next = filtering(s, i, filter, filterLength);

                if (next != current && visited.get(next) > visited.get(current) + 1) {
                    visited.set(next, visited.get(current) + 1);
                    queue.add(next);

                    if (next == B) {
                        return visited.get(B);
                    }
                }

                int nextReverse = filtering(s, i, reverse, filterLength);
                if (nextReverse != current && visited.get(nextReverse) > visited.get(current) + 1) {
                    visited.set(nextReverse, visited.get(current) + 1);
                    queue.add(nextReverse);

                    if (nextReverse == B) {
                        return visited.get(B);
                    }
                }
            }
        }

        return visited.get(B) == 1000000 ? -1 : visited.get(B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String testCase = bufferedReader.readLine();
        for (int i = 0; i < Integer.parseInt(testCase); i++) {
            String str = bufferedReader.readLine();

            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int filterLength = Integer.parseInt(stringTokenizer.nextToken());
            String filter = bufferedReader.readLine();

            System.out.println("#" + (i + 1) + " " + solution(A, B, filterLength, filter));
        }
    }
}
