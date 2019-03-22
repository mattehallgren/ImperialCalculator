package calculateimperialsystem;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculateImperialSystem {

    private static final double thou = 1;
    private static final double inch = 1000;
    private static final double foot = 12000;
    private static final double yard = 36000;
    private static final double chain = 792000;
    private static final double furlong = 7920000;
    private static final double mile = 63360000;
    private static final double league = 190080000;

    public static void main(String[] args) {

        // This rdr just uses System.in. Could just as well be a FileReader reading
        // form a file.
        try (Reader rdr = new InputStreamReader(System.in)) {
            new CalculateImperialSystem().serve(rdr);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void serve(Reader input) throws IOException {
        // Create a Map that will store the register values
        Map<String, Integer> regMap = new HashMap<>();
        LineNumberReader lnr = new LineNumberReader(input);
        String line;
        while ((line = lnr.readLine()) != null) {
            String[] ops = line.split("\\s+");
            double multiplyWith = Integer.parseInt(ops[0]);
            String fromString = ops[1];
            String toString = ops[3];
            double from = 0;
            double to = 0;
            double result;
            if (fromString.equals("thou") || fromString.equals("th")) {
                from = thou;
            } else if (fromString.equals("inch") || fromString.equals("in")) {
                from = inch;
            } else if (fromString.equals("foot") || fromString.equals("ft")) {
                from = foot;
            } else if (fromString.equals("yard") || fromString.equals("yd")) {
                from = yard;
            } else if (fromString.equals("chain") || fromString.equals("ch")) {
                from = chain;
            } else if (fromString.equals("furlong") || fromString.equals("fur")) {
                from = furlong;
            } else if (fromString.equals("mile") || fromString.equals("mi")) {
                from = mile;
            } else if (fromString.equals("league") || fromString.equals("lea")) {
                from = league;
            }
            if (toString.equals("thou") || toString.equals("th")) {
                to = thou;
            } else if (toString.equals("inch") || toString.equals("in")) {
                to = inch;
            } else if (toString.equals("foot") || toString.equals("ft")) {
                to = foot;
            } else if (toString.equals("yard") || toString.equals("yd")) {
                to = yard;
            } else if (toString.equals("chain") || toString.equals("ch")) {
                to = chain;
            } else if (toString.equals("furlong") || toString.equals("fur")) {
                to = furlong;
            } else if (toString.equals("mile") || toString.equals("mi")) {
                to = mile;
            } else if (toString.equals("league") || toString.equals("lea")) {
                to = league;
            }
            result = multiplyWith * from / to;

            System.out.println(result);
        }
    }
}
