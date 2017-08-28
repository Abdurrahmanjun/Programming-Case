package randomCases;

import java.util.HashSet;

/**
 * Created by abdurrahmanjun on 8/28/17.
 */
public class MissingInteger {

    public static int solution(int[] A) {
        HashSet<Integer> sets = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i]>0) {
                sets.add(A[i]);
            }
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!sets.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] E = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(E));
    }

}
