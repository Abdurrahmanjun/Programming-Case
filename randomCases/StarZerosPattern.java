package randomCases;

import java.util.Scanner;

/**
 * Created by abdurrahmanjun on 8/12/17.
 */
public class StarZerosPattern {

    private static void solution2(int n) {
        int length = (n * 2) -1;
        String bottomString = "x";
        String topString = "x";
        int check = 0;
        if (n % 2 == 0) {
            check = 1;
        } else {
            check = 0;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length ; j++) {
                int calculate = (i+j) % 2;
                // Bottom check
                if ((i >= (n - 1)) && (j < n) && ((i - j) <= n-1)) {
                    if (calculate == check) {
                        if (i-j == n-1){
                            bottomString = "x";
                            System.out.print(bottomString);
                        }
                        else {
                            System.out.print(bottomString);
                        }
                        if (bottomString.equals("x")) {
                            bottomString = "0";
                        }else {
                            bottomString = "x";
                        }
                    }
                    else {
                        System.out.print(".");
                    }
                }
                // Top check
                else if ((j >= (n - 1)) && (i < n) && ((j - i) <= n-1)) {
                    if (calculate == check) {
                        if (j-i == n-1){
                            topString = "x";
                            System.out.print(topString);
                        }
                        else {
                            System.out.print(topString);
                        }
                        if (topString.equals("x")) {
                            topString = "0";
                        }else {
                            topString = "x";
                        }
                    }
                    else {
                        System.out.print(".");
                    }
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine()); // the N.
        solution2(n);
    }
}
