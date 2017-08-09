package randomCases;

/**
 * Created by abdurrahmanjun on 7/28/17.
 */
class Terrain {
    private int coorX;
    private int coorToX;
    private String status;

    public Terrain() {
    }

    public Terrain(int coorX, int coorToX, String status) {
        this.coorX = coorX;
        this.coorToX = coorToX;
        this.status = status;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorToX() {
        return coorToX;
    }

    public String getStatus() {
        return status;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public void setCoorToX(int coorToX) {
        this.coorToX = coorToX;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

public class CastlePossibility {

    private static Terrain checkSameValue(int[] array,int value,int start, int loopUntil, String status) {
        Terrain terrain = new Terrain(start,loopUntil,status);
        if (loopUntil + 1 < array.length) {
            if (array[loopUntil + 1] == value) {
                loopUntil += 1;
                terrain = checkSameValue(array, value, start, loopUntil, status);
            } else if (array[loopUntil + 1] < value) {
                if (status.equals("hills") || status.equals("netral")) {
                    terrain.setStatus("hills");
                } else {
                    terrain.setStatus("not-hills");
                }
            } else if (array[loopUntil + 1] > value) {
                if (status.equals("valley") || status.equals("netral")) {
                    terrain.setStatus("valley");
                } else {
                    terrain.setStatus("not-valley");
                }
            }
        }
        return terrain;
    }

    private static int solution2(int[] array) {
        int total = 0;
        int length = array.length;

        for (int i = 0; i < length ; i++) {
            Terrain terrain = new Terrain();
            if (i == 0) {
                terrain = checkSameValue(array, array[i], i, i, "netral");
            } else {
                if (array[i - 1] > array[i]) {
                    terrain = checkSameValue(array, array[i], i, i, "valley");
                } else if (array[i - 1] < array[i]) {
                    terrain = checkSameValue(array, array[i], i, i, "hills");
                }
            }
            if ((terrain.getStatus() == "valley") || (terrain.getStatus() == "hills")) {
                total = total + 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,3,4,3,3,2,2,1,1,2,2};
        System.out.println(solution2(a));
    }
}
