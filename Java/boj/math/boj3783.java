package CodeTest.Java.boj.math;

import java.io.*;
import java.math.*;

public class boj3783 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String input = br.readLine()+".0000000000";
        
        BigDecimal n = new BigDecimal(input);

        BigDecimal root = nthRoot(3, n, 500);

        root = root.setScale(10, RoundingMode.DOWN);
        sb.append(root.toPlainString()).append("\n");
    }

    private static BigDecimal nthRoot(int n, BigDecimal value, int scale) {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = BigDecimal.valueOf(Math.pow(value.doubleValue(), 1.0/n));

        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = BigDecimal.valueOf(n-1)
                         .multiply(x1)
                         .add(value.divide(x1.pow(n-1), scale, RoundingMode.HALF_UP))
                         .divide(BigDecimal.valueOf(n), scale, RoundingMode.HALF_UP);
        }
        return x1;
    }
}
