package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.*;

public class 가사검색 {

    private static String reverse(String word) {
        char ch[]=word.toCharArray();
        int size=ch.length;
        for(int i=0;i<size/2;i++){
            char temp=ch[i];
            ch[i]=ch[size-1-i];
            ch[size-1-i]=temp;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String words[]={"frodo", "front", "frost", "frozen", "frame", "kakao", "kakaa"};
        String reverseWords[]=new String[words.length];
        String queries[]={"fro??", "????o", "fr???", "fro???","pro?","kaka?"};
        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
        HashMap<Integer,ArrayList<String>> reverseMap=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<words.length;i++) {
            reverseWords[i] = reverse(words[i]);
        }

        for(String word:words){
            if (!map.containsKey(word.length())) {
                map.put(word.length(), new ArrayList<>());
            }
            map.get(word.length()).add(word);
        }

        for(String reverseWord:reverseWords){
            if (!reverseMap.containsKey(reverseWord.length())) {
                reverseMap.put(reverseWord.length(), new ArrayList<>());
            }
            reverseMap.get(reverseWord.length()).add(reverseWord);
        }

        for(String query:queries){
            String Keyword="";
            ArrayList<String> list=new ArrayList<>();

            if(query.indexOf('?')==0){
                String str=reverse(query);
                Keyword=str.substring(0,str.indexOf('?'));
                list=reverseMap.get(query.length());
            }else{
                Keyword=query.substring(0,query.indexOf('?'));
                list=map.get(query.length());
            }

            if(list==null){
                result.add(0);
                continue;
            }
            Collections.sort(list);
//            System.out.println(list.toString());
//            System.out.println(Keyword);
//            System.out.println(list.size());
            int start=0;
            int end=list.size();
            int count=0;
            while(start<=end){ //포함되는 문자열의 count를 찾기
                int mid= (start+end)/2;
                if(list.get(mid).startsWith(Keyword)){
                    count++;
                    int left=mid-1;
                    int right=mid+1;
                    while(true){
                        if(left>-1&& list.get(left).startsWith(Keyword)){
                            count++;
                            left--;
                        }else if(right<list.size()&&list.get(right).startsWith(Keyword)){
                            count++;
                            right++;
                        }else{
                            break;
                        }
                    }
                    break;
                }else{
                    if(list.get(mid).compareTo(Keyword)<0){
                        start=mid+1;
                    }else {
                        end=mid-1;
                    }
                }
            }
            result.add(count);
        }
        int resultList[]=new int[result.size()];
        for(int i=0;i<result.size();i++)
            resultList[i]=result.get(i);
        System.out.println(result.toString());
    }
}
