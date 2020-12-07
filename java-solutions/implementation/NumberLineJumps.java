import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NumberLineJumps {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int y1 = x1 + v1;
        int y2 = x2 + v2;
        if (
            (y1 > y2 && v1 > v2) ||
            (y2 > y1 && v2 > v1)
        ) {
            return "NO";
        } else {
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                int n1 = x1 + v1 * i;
                int n2 = x2 + v2 * i;
                if (n2 - n1 == 0) return "YES";
                if (n2 - n1 < diff) diff = n2 - n1;
                else return "NO";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
