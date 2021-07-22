package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 트라이 구축
 * 	class Node
 * 		- Object data
 * 		- Node child[]
 * 	    - isEnd -> 단어의 끝 표시
 * 	    - isHit -> 해당 단어를 찾은 위치
 * 트라이 노드 설계
 * 단어 사전의 입력할 단어를 트라이에 삽입
 * Root 노드부터 시작하여 단어의 첫 글자부터 트라이를 탐색
 * 만약 현재 노드의 자식 노드중 현재 입력중인 철차에 해당하는 자식이 있다면
 * 현재 노드를 해당하는 자식 노드로 이동
 * 만약 현재노드의 자식 노드중 현재 입력 중인 철자에 해당하는 자식이 없다면,
 * 새로운 자식을 추가
 * - 단어를 삽입 후, 탐색된 마지막 노드에 현재 입력된 단어의 정보를 추가
 */
/*
5
ICPC
ACM
CONTEST
GCPC
PROGRAMM

3
ACMA
APCA
TOGI
NEST

PCMM
RXAI
ORCN
GPCG

ICPC
GCPC
ICPC
GCPC
 */
public class 트라이설계 {

    static StringBuilder sb;
    static TrieNode root;
    static final int maxSize = 8;
    static int score[];
    static int sum;
    static int count;
    static String answer;
    static char[][] map;
    static boolean[][] visited;
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    static int dy[] = {-1, -1, 0 , 1, 1, 1, 0 , -1};

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        boolean isHit;

        void clearHit() {
            isHit = false;
            for (int i = 0; i < children.length; i++) {
                if(children[i] != null) children[i].clearHit();
            }
        }

        boolean hasChild(char c) {
            return children[c - 'A'] != null;
        }

        TrieNode getChild(char c) {
            return children[c - 'A'];
        }
    }

    static void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'A';
            if (current.children[wordIndex] == null) {
                current.children[wordIndex] = new TrieNode();
            }
            current = current.children[wordIndex];
        }
        current.isEnd = true;

    }

    static boolean containNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'A';
            if (current.children[wordIndex] == null) {
                return false;
            }
            current = current.children[wordIndex];
        }
        return true;
    }

    static int compare(String str1, String str2) {
        if(str1.length() == str2.length()) return str1.compareTo(str2);
        else return str1.length() - str2.length() < 0 ? 1 : - 1;

    }

    static void search(int y, int x, int len, TrieNode node) {

        // 1. 체크인
        visited[y][x] = true;
        sb.append(map[y][x]); //백트래킹

        // 2. 목적지에 도달하였는가?
        if(node.isEnd && !node.isHit) {
            node.isHit = true;
            sum += score[len];
            count++;
            String resultWord = sb.toString();
            if(compare(answer, resultWord) > 0) {
                answer = resultWord;
            }
        }

        // 3. 연결된 곳을 순회
        for (int i = 0; i < 8; i++) {
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            // 4. 가능한가? -> 경계 , 방문 여부, node가 해당 자식을 가지고 있는지
            if( 0 <= next_y && 0<= next_x && next_x < 4 && next_y < 4) {
                if(!visited[next_y][next_x] && node.hasChild(map[next_y][next_x])) {
                    // 5. 간다
                    search(next_y, next_x, len + 1, node.getChild(map[next_y][next_x]));
                }
            }

        }

        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        score = new int[]{0, 0, 0, 1, 1, 2, 3, 5, 11};
        root = new TrieNode();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            String str = input.readLine();
            insert(str);
        }
        input.readLine();
        int m = Integer.parseInt(input.readLine());
        for(int i = 0; i < m; i++) {

            sb = new StringBuilder();
            sum = 0;
            count = 0;
            answer = "";
            map = new char[4][4];
            visited = new boolean[4][4];

            for(int j = 0; j < 4; j++){
                String str = input.readLine();
                for(int k = 0; k < 4; k++) {
                    map[j][k] = str.charAt(k);
                }
            }
            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 4; x++) {
                    if(root.hasChild(map[y][x])) {
                        search(y, x, 1, root.getChild(map[y][x]));
                    }
                }
            }

            result.append(sum).append(" ").append(answer).append(" ").append(count).append("\n");
            root.clearHit();
            input.readLine();
        }

        System.out.println(result);

    }
}
