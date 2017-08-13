package randomCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abdurrahmanjun on 8/10/17.
 */
class Ground {
    private int coorX;
    private int coorY;
    private String value;
    private boolean visited = false;

    public Ground(int coorX, int coorY, String value) {
        this.coorX = coorX;
        this.coorY = coorY;
        this.value = value;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public String getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

class Army extends Ground {
    private List<Army> rivals = null;
    private List<Army> partners = null;

    public Army(int coorX, int coorY, String value) {
        super(coorX, coorY, value);
    }

    public List<Army> getRivals() {
        return rivals;
    }

    public void setRivals(List<Army> rivals) {
        this.rivals = rivals;
    }

    public List<Army> getPartners() {
        return partners;
    }

    public void setPartners(List<Army> partners) {
        this.partners = partners;
    }
}

public class ConquerTheLand {

    private static String[][] toMatrix(String[] arrayOfString, int lines, int coloumns){
        String[][] matrixString = new String[lines][coloumns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < coloumns ; j++) {
                matrixString[i][j]= String.valueOf(arrayOfString[i].charAt(j));
            }
        }
        return matrixString;
    }

    private static void findArmy(String[][] map) {
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                if (!map[i][j].equals("#") && !map[i][j].equals(".")) {
                    // aha! army founded.
                    Army army = checkNeighbors(i,j,map);


                }
            }
        }
    }

    private static Army checkNeighbors(int i, int j, String[][] map) {
        List<Ground> neighbors = new ArrayList<>();
        Army army = new Army(i,j,map[i][j]);
        army.setVisited(true);

        Ground top = generateGround(i,j-1,map);
        Ground right = generateGround(i+1,j,map);
        Ground bottom = generateGround(i,j+1,map);
        Ground left = generateGround(i-1,j,map);

        if (!top.isVisited()) {
            neighbors.add(top);
        }
        if (!right.isVisited()) {
            neighbors.add(right);
        }
        if (!bottom.isVisited()) {
            neighbors.add(bottom);
        }
        if (!left.isVisited()) {
            neighbors.add(left);
        }

        return army;
    }

    public static Ground generateGround(int i, int j, String[][] map) {
        Ground output;
        if (i<0 || j<0 || i>map.length || j>map[0].length) {
            return output = null;
        } else if (!map[i][j].equals("#") && !map[i][j].equals(".")) {
            return output = null;
        } else {
            output = new Ground(i,j,map[i][j]);
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intT = Integer.parseInt(in.nextLine()); // amount of test
        String[][] matrixNextLines = new String[intT][2];

        for (int i = 0; i < intT ; i++) {
            int j = 0;
            matrixNextLines[i][0] = in.nextLine();
            matrixNextLines[i][1] = in.nextLine();
            int lengtOfString = Integer.parseInt(matrixNextLines[i][0]);
            String[] arrayOfString = new String[lengtOfString];
            while (j < lengtOfString) {
                arrayOfString[j] = in.nextLine();
                j++;
            }
            findArmy(toMatrix(arrayOfString,Integer.parseInt(matrixNextLines[i][0]),Integer.parseInt(matrixNextLines[i][1])));
        }
    }
}
