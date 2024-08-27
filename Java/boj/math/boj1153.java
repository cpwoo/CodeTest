package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1153 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int max = 1000001;

        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for(int i=2; i<Math.sqrt(max)+1; i++) {
            if(sieve[i]) {
                for(int j=i*i; j<max; j+=i) sieve[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        List<Integer> prime = new ArrayList<>();
        for(int i=2; i<n+1; i++) {
            if(sieve[i]) prime.add(i);
        }

        if(n < 8) {
            bw.write("-1");
            return;
        }

        List<Integer> ret = new ArrayList<>();
        if(n%2 == 0) {
            ret.add(2); ret.add(2);
            n -= 4;
        }
        else {
            ret.add(2); ret.add(3);
            n -= 5;
        }

        boolean flag = false;
        for(int i=0; i<prime.size(); i++) {
            for(int j=0; j<prime.size(); j++) {
                int tot = prime.get(i)+prime.get(j);
                if(tot == n) {
                    ret.add(prime.get(i));
                    ret.add(prime.get(j));
                    flag = true;
                    break;
                }
                else if(tot > n) break;
            }
            if(flag) break;
        }

        sb = new StringBuilder();
        for(int i=0; i<4; i++) sb.append(ret.get(i)).append(' ');

        bw.write(sb.toString());
    }

}
