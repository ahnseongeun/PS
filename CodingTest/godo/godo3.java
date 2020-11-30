package CodingTest.godo;

//https://tuanwiki.wordpress.com/2011/08/20/topcoder-rough-strings/
/*
문제 설명
문자열 String s의 거친 정도는 다음과 같이 계산할 수 있다. s에서 가장 많이 등장하는 글자를 c1이라 하고, 가장 적게 등장하는 글자를 c2라 한다 (c2는 반드시 한번 이상은 등장해야 한다). s의 거친 정도는 c1이 등장하는 횟수에서 c2가 등장하는 횟수를 뺀 숫자이다.

당신은 주어진 문자열 s에서 0개 이상, int n개 이하의 글자를 삭제하는 방법으로 문자열을 변경할 수 있다 (명확한 이해를 위해 예제를 참조하라). 이 방법을 이용하여 얻을 수 있는 가장 적은 문자의 거친 정도를 반환하여라.

참고 / 제약 사항
s는 1개 이상, 50개 이하의 글자를 가진다.
s는 소문자만 가진다 ('a'-'z').
n은 0이상, m-1이하이다. 이 때, m은 s에 있는 글자의 개수이다.
테스트 케이스
String s = "aaaaabbc"
int n = 1리턴(정답): 3
하나의 'a'를 삭제하거나 하나의 'c'를 삭제하여 최소의 거친 정도 3을 얻을 수 있다.

String s = "aaaabbbbc"
int n = 5리턴(정답): 0
'c'와 모든 'a'를 지우는 방법이 있다.
*/
public class godo3 {
    public static void main(String[] args) throws Exception{
        String s = "aaaabbbbbbccccccccccc";
        int n=1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']++;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]) {
                max = arr[i];
            }
            if(arr[i]>=1&&min>arr[i]) {
                min=arr[i];
            }
        }
        if(max+min<n){
            System.out.println(0);
        }else{
            for(int i=0;i<n;i++){
                if(max!=0){
                    max--;
                }else{
                    min--;
                }
            }
            System.out.println(Math.abs(max-min));
        }
    }
}
