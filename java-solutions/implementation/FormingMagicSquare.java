import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FormingMagicSquare {

    static int[][] m = new int[][] {
        { 4, 9, 2 },
        { 3, 5, 7 },
        { 8, 1, 6 }
    };

    static int[][][] magicSquares() {
        int[][][] ms = new int[8][3][3];
        ms[0] = m;
        ms[1] = mirrorMatrix(m, true);
        ms[2] = mirrorMatrix(m, false);
        ms[3] = mirrorMatrix(ms[2], true);
        ms[4] = rotateMatrix(m, true);
        ms[5] = rotateMatrix(ms[1], true);
        ms[6] = rotateMatrix(ms[2], true);
        ms[7] = rotateMatrix(ms[3], true);
        return ms;
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][][] ms = magicSquares();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ms.length; i++) {
            int cost = 0;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (s[y][x] != ms[i][y][x]) {
                        cost += Math.abs(ms[i][y][x] - s[y][x]);
                    }
                }
            }
            if (cost < min) min = cost;
        }
        return min;
    }

    static int[][] transposeMatrix(int[][] m) {
        int[][] n = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                n[j][i] = m[i][j];
            }
        }
        return n;
    }

    static int[][] mirrorMatrix(int[][] m, boolean horiz) {
        int[][] n = new int[m.length][m[0].length];
        if (horiz) {
            for (int i = 0; i < m.length; i++) {
                for (int j = m[0].length - 1; j >= 0; j--) {
                    n[i][j] = m[i][m[0].length - 1 - j];
                }
            }
        } else {
            for (int i = m.length - 1; i >= 0; i--) {
                for (int j = 0; j < m[0].length; j++) {
                    n[i][j] = m[m.length - 1- i][j];
                }
            }
        }
        return n;
    }

    static int[][] rotateMatrix(int[][] m, boolean clockwise) {
        if (clockwise) {
            return mirrorMatrix(transposeMatrix(m), true);
        } else {
            return mirrorMatrix(transposeMatrix(m), false);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        */
        // int[][][] ms = magicSquares();
        // for (int i = 0; i < 8; i++) {
        //     System.out.println("---" + i + "--");
        //     printMatrix(ms[i]);
        //     System.out.println("--------------");
        // }
        int[][] test = new int[][] {
            { 4, 9, 2 },
            { 3, 5, 7 },
            { 8, 1, 5 }
        };
        int n = formingMagicSquare(test);
        System.out.println(n);
    }

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + ", ");
            }
            System.out.print("\n");
        }
    }
}
