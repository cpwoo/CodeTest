package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1132 {
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
        
        long[] alpha = new long[10];
        boolean[] check = new boolean[10];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            long num = 1;
            check[line.charAt(0)-'A'] = true;
            for(int s=line.length()-1; s>=0; s--) {
                alpha[line.charAt(s)-'A'] += num;
                num *= 10;
            }
        }

        int idx = 0;
        for(int i=0; i<10; i++) {
            if(!check[i]) {
                idx = i;
                break;
            }
        }

        for(int i=0; i<10; i++) {
            if(!check[i] && alpha[i] < alpha[idx]) idx = i;
        }

        alpha[idx] = 0;
        Arrays.sort(alpha);

        long ret = 0;
        for(int i=9; i>=0; i--) {
            if(alpha[i] == 0) break;
            ret += alpha[i]*i;
        }

        bw.write(ret+"");
    }

}
