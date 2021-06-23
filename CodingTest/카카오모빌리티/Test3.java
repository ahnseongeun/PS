package CodingTest.카카오모빌리티;

//7 4 -2 4 -2 9
public class Test3 {

    private static int check(int left, int right, int[] a) {

        int cnt = 0;
        int value1 = -1000000001;
        int value2 = -1000000001;
        for(int i = left; i < right; i++){
            if(i % 2 == 0){
                if(value1 == -1000000001){
                    value1 = a[i];
                }else{
                    if(value1 != a[i]) return -1;
                }
            }else{
                if(value2 == -1000000001){
                    value2 = a[i];
                }else{
                    if(value2 != a[i]) return -1;
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        int[] A = {3,2,3,2,1};
        int size = A.length;
        int left = 0;
        int right = 0;
        int result = 0;
        while(left < size){

            int num = check(left, right, A);

            //만족하지 않는다면 왼쪽한칸 줄이기
            if(num == -1 || right == A.length){
                left++;
            //만족한다면 오른쪽한칸 늘리기
            }else{
                if(right < size)
                    right++;
            }
            result = Math.max(result,num);
        }
        System.out.println(result);
    }
}
