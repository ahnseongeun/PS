package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열압축 {
    private static int compressCharacter(String str, int compressSize) {
        StringBuilder sb = new StringBuilder();
        String startWord = str.substring(0,compressSize);
        String compareWord="";
        //System.out.println("startWord: "+startWord);
        int equalCount=1;
        for(int i=compressSize;i<=str.length();i+=compressSize){
            if(i+compressSize>str.length())
                compareWord = str.substring(i);
            else
                compareWord = str.substring(i,i+compressSize);
            //System.out.println("compareWord: "+compareWord);
            if(startWord.equals(compareWord)){
                equalCount++;
            }else{
                if(equalCount==1)
                    sb.append(startWord);
                else
                    sb.append(startWord+equalCount);
                startWord=compareWord;
                equalCount=1;
            }
        }
        sb.append(compareWord);
        //System.out.println(sb);
        return sb.length();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String str=input.readLine();
        int strLength[]=new int[str.length()+1];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<str.length();i++){
            strLength[i]=compressCharacter(str,i);
            min=Math.min(min,strLength[i]);
        }
        System.out.println(str.length()==1?1:min);
    }
}
