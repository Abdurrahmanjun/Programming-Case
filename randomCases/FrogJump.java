package randomCases;

/**
 * Created by abdurrahmanjun on 8/28/17.
 */
public class FrogJump {

    private static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int jump = (Y - X) / D;
        if ((Y - X) % D > 0) {
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {

        System.out.println(solution(10, 85, 30));
    }
}
