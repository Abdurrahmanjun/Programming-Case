package randomCases;

import java.util.Arrays;

/**
 * Created by abdurrahmanjun on 8/30/17.
 */
public class OnTimeSwap {
    public static boolean solution(int[] A) {
        int countSwap = 0;
        boolean checkBool = false;
        for (int i = 0; i < A.length; i++) {
            int[] check = new int[2];
            for (int j = i + 1; j < A.length; j++) {
                if (j == i + 1) {
                    check[0] = j;
                    check[1] = A[j];
                }
                if (A[j] < A[i]) {
                    check[0] = j;
                    check[1] = A[j];
                    checkBool = true;
                }
            }
            if (checkBool) {
                if (countSwap > 1) {
                    return false;
                }
                A[check[0]] = A[i];
                A[i] = check[1];
                checkBool = false;
                countSwap++;
            }
        }
        return countSwap <= 1;
    }

    public static void main(String[] args) {

        int[] E1 = {1, 4, 5, 2, 7, 3, 6};
        int[]A = {1,2};
        int[]B = {1,3,6,3,5,5,3,7,7};
        int[]C = {1, 4, 5, 6, 7, 2};
        int[]D = {1,2,3,4,5,6,7,8,9,10,11,2,45,56,67,78,89,90,123,124,1245566778};
        int[]D1 = {1,2,3,4,5,6,7,8,9,10,11,2,45,56,67,78,89,90,2,123,124,1245566778};
        int[]E = {1, 5, 3, 3, 7} ;
        int[]F= {1, 3, 5};
        int[]G = {1,5,3};
        int[]TEST = {1,6,5,2};

        System.out.println(solution(E1));
        System.out.println();

        System.out.println("true = "+solution(A));
        System.out.println("true = "+solution(B));
        System.out.println("false = "+solution(C));
        System.out.println("false = "+solution(D));
        System.out.println("false = "+solution(D1));
        System.out.println("true = "+solution(E));
        System.out.println("true = "+solution(F));
        System.out.println("true = "+solution(G));
        System.out.println("true = "+solution(TEST));
    }
}
