import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

    static void customExtraLongFactorial(int n) {
        String result = "1";
        for (int i = 1; i <= n; i++) {
            result = multiply(result, Integer.toString(i));
        }
        System.out.println(result);
    }

    static String multiply(String x, String y) {
        String finalResult = "";
        for (int i = y.length() - 1; i >= 0; i--) {
            int multiplier = Integer.parseInt(y.charAt(i) + "");
            int remainder = 0;
            String multiplyResult = "0".repeat(y.length() - 1 - i);
            for (int j = x.length() - 1; j >= 0; j--) {
                int digit = Integer.parseInt(x.charAt(j) + "");
                int result = multiplier * digit + remainder;
                remainder = result / 10;
                multiplyResult = Integer.toString(result % 10) + multiplyResult;
            }
            multiplyResult = Integer.toString(remainder) + multiplyResult;
            finalResult = add(finalResult, multiplyResult);
            
        }
        return finalResult.replaceAll("^0+(?!$)", "");
    }

    static String add(String x, String y) {
        if (x.length() > y.length()) {
            y = "0".repeat(x.length() - y.length()) + y;
        } else if (x.length() < y.length()) {
            x = "0".repeat(y.length() - x.length()) + x;
        }
        int remainder = 0;
        String finalResult = "";
        for (int i = x.length() - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(x.charAt(i) + "");
            int n2 = Integer.parseInt(y.charAt(i) + "");
            int result = n1 + n2 + remainder;
            remainder = result / 10;
            finalResult = Integer.toString(result % 10) + finalResult;
        }
        finalResult = Integer.toString(remainder) + finalResult;
        return finalResult.replaceAll("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        // System.out.println(add(multiply("96138", "981"), "741"));
        customExtraLongFactorial(25);
    }
}
