package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열압축 {
    private static int compressCharacter(String str, int compressSize) {
        StringBuilder sb = new StringBuilder();
        String startWord = str.substring(0,compressSize); //compressSize만큼 startWord를 지정한다.
        String compareWord="";
        //System.out.println("startWord: "+startWord);
        int equalCount=1; //초기 비교 count는 1
        for(int i=compressSize;i<=str.length();i+=compressSize){ //compressSize마다 단어수 늘리기
            if(i+compressSize>str.length()) //subString을 하기 위한 길이가 되는지 안되는지 판별
                compareWord = str.substring(i); //안되면 남은 문장 이어 붙이기
            else
                compareWord = str.substring(i,i+compressSize); //되면 비교 문장 갱신
            //System.out.println("compareWord: "+compareWord);
            if(startWord.equals(compareWord)){ //일치하면 equalCount 증가
                equalCount++;
            }else{
                if(equalCount==1) //equalCount가 1이면 생략 가능
                    sb.append(startWord);
                else
                    sb.append(startWord+equalCount); //equalcount와 시작 단어 삽입
                startWord=compareWord; //시작 단어를 갱신
                equalCount=1; //equalCount 1로 초기화
            }
        }
        sb.append(compareWord); //남은 단어 이어 붙이기
        //System.out.println(sb);
        return sb.length();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String str=input.readLine();
        int strLength[]=new int[str.length()+1];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<str.length();i++){
            strLength[i]=compressCharacter(str,i); //자리수 마다 압축된 결과를 저장
            min=Math.min(min,strLength[i]);
        }
        System.out.println(str.length()==1?1:min); //단어의 길이가 1일 경우 고려
    }
}
