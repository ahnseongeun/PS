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

    static TrieNode root;
    static final int maxSize = 8;
    static int score[];
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1}; //상 우상 우 우하 하 좌하 좌 좌상
    static int dy[] = {-1, -1, 0 , 1, 1, 1, 0 , -1};

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        boolean isHit;

        void clearHit() {
            isHit = false;
            for (int i = 0; i < children.length; i++) {
                children[i].clearHit();
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

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        score = new int[]{0, 0, 0, 1, 1, 2, 3, 5, 11};
        for(int i = 0; i < n; i++) {
            String str = input.readLine();
            insert(str);
        }

        int m = Integer.parseInt(input.readLine());
        for(int i = 0; i < m; i++) {
            char[][] map = new char[4][4];
            for(int j = 0; j < 4; j++){
                String str = input.readLine();
                for(int k = 0; k < 4; k++) {
                    map[j][k] = str.charAt(k);
                }
            }
            for(int j = 0; j < 4; j++) {

            }
        }

    }
}
