package CodeTest.Java.boj.impl;

import java.io.*;
import java.math.*;
import java.util.*;

public class boj1036 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        BigInteger ret = BigInteger.ZERO;
        BigInteger[] diff = new BigInteger[36];
        Arrays.fill(diff, BigInteger.ZERO);

        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            BigInteger val = new BigInteger(inp, 36);
            BigInteger pow = BigInteger.ONE;
            ret = ret.add(val);
            for(int j=0; j<inp.length(); j++) {
                int idx = Dec(inp.charAt(inp.length()-j-1));
                diff[idx] = diff[idx].add(pow.multiply(BigInteger.valueOf(35-idx)));
                pow = pow.multiply(BigInteger.valueOf(36));
            }
        }

        Arrays.sort(diff);

        int k = Integer.parseInt(br.readLine());
        for(int i=35; i>35-k; i--) ret = ret.add(diff[i]);

        bw.write(ret.toString(36).toUpperCase());
    }

    private static int Dec(char x) {
        return ('0' <= x && x <= '9') ? x-48 : x-55;
    }

}
