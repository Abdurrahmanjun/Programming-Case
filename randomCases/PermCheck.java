package randomCases;

/**
 * Created by abdurrahmanjun on 8/28/17.
 */
public class PermCheck {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        boolean[] boolCheck = new boolean[A.length+1];

        for(int i=0; i<A.length; i++) {
            if(A[i] < A.length+1 && A[i]>0 && !boolCheck[A[i]]) {
                boolCheck[A[i]] = true;
            }
            else {
                return 0;
            }
        }

        for(int i=1; i<A.length+1; i++) {
            if (!boolCheck[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] E = {4, 1, 3, 2};
        int[] F = {4, 1, 3};
        System.out.println(solution(E));
        System.out.println(solution(F));
    }

}
