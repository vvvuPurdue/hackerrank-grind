import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double[] pnz = new double[] { 0, 0, 0 };
        for (int n : arr) {
            if (n > 0) {
                pnz[0] += 1;
            } else if (n < 0) {
                pnz[1] += 1;
            } else {
                pnz[2] += 1;
            }
        }
        System.out.printf("%.6f" + "\n", pnz[0] / arr.length);
        System.out.printf("%.6f" + "\n", pnz[1] / arr.length);
        System.out.printf("%.6f" + "\n", pnz[2] / arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
