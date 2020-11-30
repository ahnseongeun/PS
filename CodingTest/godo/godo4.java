package CodingTest.godo;

/*문제 설명
        "온라인 결제시스템을 개발하는 개발자가 여러 종류의 신용카드를 지원하고 싶어한다. 하지만 카드번호가 길어서 입력하다 실수하는 경우가 잦으므로 사용자가 입력한 번호를 확인할 방법이 필요하다.

        개발자는 다음과 같은 "룬 알고리즘"이 모든 카드에 적용됨을 알고 있다.
        먼저 각 신용카드의 각 숫자를 쪼갠다. 예를 들어서, 21378은
        2 1 3 7 8

        만약 짝수 개수의 숫자가 존재한다면 홀수의 위치에 있는 숫자에 2를 곱한다. 반대로 홀수 개수의 숫자가 존재한다면 짝수의 위치에 있는 숫자에 2를 곱한다. 위치를 구할 때는 첫번째 숫자를 1로 지정한다. 위에 예시로 든 번호는 홀수 개수의 숫자가 있으므로 짝수의 위치에 있는 숫자에 2를 곱한다:

        2 1 3 7 8 은
        2 2 3 14 8 이 된다.

        이 때, 짝수의 위치에 있는 숫자는 고유한 숫자이므로 2자리 수가 나타나더라도 변형해서는 안 된다는 것을 유의한다.

        마지막으로 모든 숫자를 쪼개어 합을 구한다 (2자리 숫자인 경우에는 각 자리의 숫자를 다른 수로 취급하여 합에 더해야 한다):

        2 + 2 + 3 + 1 + 4 + 8 = 20

        합이 10의 배수라면 이는 유효한 번호이다. 그렇지 않다면 유효하지 않은 번호이다.

        신용카드번호 String cardNumber에 대하여 카드번호가 유효하다면 "VALID", 그렇지 않다면 "INVALID"를 반환하라. (따옴표는 문자열을 나타내기 위함일 뿐이며 결과값에는 포함되지 않는다)"

        참고 / 제약 사항
        cardNumber는 1개 이상, 50개 이하의 문자를 가진다.
        cardNumber의 각 문자는 숫자이다 ('0'-'9').
        테스트 케이스
        String cardNumber = "21378"리턴(정답): "VALID"
        홀수 개수의 숫자를 가지고 있으므로, 짝수의 위치에 있는 숫자에 2를 곱하면 다음과 같다. 2 2 3 14 8 각 숫자의 합은 20이므로 이는 10의 배수이기 때문에 유효한 번호가 된다.

        String cardNumber = "31378"리턴(정답): "INVALID"
        룬 알고리즘을 적용하면 합은 21이 되므로 이 번호는 유효하지 않다.

        String cardNumber = "11111101"리턴(정답): "VALID"
        홀수의 위치에 있는 숫자에 2를 곱하면 다음과 같다. 2 1 2 1 2 1 0 1 각 숫자의 합은 10이므로 이는 유효한 번호이다.

        String cardNumber = "50005"리턴(정답): "VALID"
        짝수의 위치에 있는 숫자들이 0이므로 2를 곱하여도 아무런 변화가 없다. 각 숫자들의 합이 10이므로 이는 유효한 카드번호이다.

        String cardNumber = "26227174957722514961366"리턴(정답): "INVALID"*/
public class godo4 {
    public static void main(String[] args) throws Exception{
        String cardNumber = "21378";
        int size=cardNumber.length();
        int arr[]=new int[size+1];
        int sum=0;
        for(int i=1;i<=size;i++)
            arr[i]=cardNumber.charAt(i-1)-'0';
        if(size%2==0){   //짝수
            for(int i=1;i<=size;i++) {
                if(i%2==1){ //홀수 *2
                    int a=arr[i]*2;
                    int b=a/10;
                    int c=a%10;
                    sum+=(b+c);
                }else {
                    sum+=arr[i];
                }
            }
        }else{
            //짝수 *2
            for(int i=1;i<=size;i++) {
                if(i%2==0){ //홀수
                    int a=arr[i]*2;
                    int b=a/10;
                    int c=a%10;
                    sum+=(b+c);
                }else {
                    sum+=arr[i];
                }
            }
        }
        if(sum%10==0)
            System.out.println("VALID");
        else
            System.out.println("INVALID");
    }
}
