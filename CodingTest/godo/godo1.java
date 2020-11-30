package CodingTest.godo;

import java.util.Arrays;

public class godo1 {
    public static void main(String[] args) throws Exception{
        int goods[]={1,2,3,};
        Arrays.sort(goods);
        int sum=0;
        int result=0;
        for(int i=0;i<goods.length;i++){
            sum+=goods[i];
            if(sum>=50){
                result+=(sum-10);
                sum=0;
            }else{
                if(i== goods.length-1){
                    result+=sum;
                }
            }

        }

    }
}
