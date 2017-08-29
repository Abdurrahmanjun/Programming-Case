package randomCases;

/**
 * Created by abdurrahmanjun on 8/29/17.
 */
public class FrogRiverOne {

    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        boolean[] leafCheck = new boolean[X+1];
        int secondCount = 0;

        for(int i=0; i<A.length; i++) {
            if (!leafCheck[A[i]]) {
                leafCheck[A[i]] = true;
                secondCount++;
            }

            if(secondCount==X) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] E = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(5, E));
    }
}
