package randomCases;

/**
 * Created by abdurrahmanjun on 8/28/17.
 */
public class TapeEquilibrium {

    private static int solution(int[] A) {
        // write your code in Java SE 8
        int total = 0;
        int check = 0;
        int minDiff = 0;

        for (int i=0; i<A.length; i++) {
            total += A[i];
        }
        System.out.println(total);

        for (int i=0; i<A.length; i++) {
            check = check + A[i];
            int min = Math.abs((total - check) - check);
            System.out.println(min+" "+total+" "+check);
            if (i==0) {
                minDiff = min;
            }
            else if (total - check==0) {
                break;
            }
            else if (minDiff > min) {
                minDiff = min;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {

        int[] E = {3, 1, 2, 4, 3};
        System.out.println(solution(E));
    }
}
