package DataStructure.BinarySearch;

public class 이분탐색템플릿 {

    public static  int binarySearch(int[] list, int key) {
        // 맨처음 low = 0, high는 배열의 끝이다.
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2; // mid 값을 계산.

            if (key > list[mid]) // 키값이 더 크면 왼쪽을 버린다.
                low = mid + 1;
            else if (key < list[mid]) // 키값이 더 작으면 오른쪽을 버린다.
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    public static int lowerBound(int[] array,  int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
