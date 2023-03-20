package DataStructure.programmers;

public class 덧칠하기_refactoring {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int currentValue = 1;
        int result = 0;
        int[] section = {2,3,6};

        for ( int i = 0; i < section.length; i++) {
            if (currentValue <= section[i]) {
                currentValue += m;
                result += 1;
            }
        }
    }
}
