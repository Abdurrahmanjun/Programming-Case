package randomCases;

/**
 * Created by abdurrahmanjun on 8/28/17.
 */
public class MissingInteger {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int range = A.length+1;
        boolean[] bool = new boolean[range+1];

        for(int i = 0; i < A.length; i++) {
            if (!bool[A[i]] && A[i]<range && A[i]>0) {
                bool[A[i]] = true;
            }
        }

        for(int i = 1; i<=range; i++) {
            if (!bool[i]) { return i; };
        }

        return 0;
    }


    public static void main(String[] args) {

        int[] E = {2, 3, 1, 5, 4};
        System.out.println(solution(E));
    }

}
