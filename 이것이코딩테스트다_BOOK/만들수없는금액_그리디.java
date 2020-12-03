package 이것이코딩테스트다_BOOK;

public class 만들수없는금액_그리디 {
    public static void main(String[] args){
        int arr[]={1,1,1,1,11};
        int target=1;
        for(int i=0;i<arr.length;i++){
            if(target<arr[i])
                break;
            target+=arr[i];
        }
        System.out.println(target);
    }
}
