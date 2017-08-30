package randomCases;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by abdurrahmanjun on 8/30/17.
 */
public class MaxCounters {
    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int lastMax = 0;
        int[] counters = new int[N];
        for(int i=0; i<A.length; i++) {
            if (A[i]>0 && A[i]<=N) {
                counters[A[i]-1] = Math.max(counters[A[i]-1],lastMax);
                counters[A[i]-1] += 1;
                max = Math.max(counters[A[i]-1],max); // is it bigger then the lastOne?
            }
            else if (A[i] == N+1) {
                lastMax = max;
            }
        }

        for(int i=0; i<counters.length; i++) {
            counters[i] = Math.max(counters[i],lastMax);
        }
        return counters;
    }

    public static void main(String[] args) {
        int[] E = {3, 4, 4, 6, 1, 4, 4};
        int[] F = {6, 6, 6, 6, 6, 6};
        System.out.println(Arrays.toString(solution(5, E)));
        System.out.println();
    }
}
