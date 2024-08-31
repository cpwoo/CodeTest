package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj15711 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static List<Long> q;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int max = 2_000_001;

        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        
        for(int i=2; i<(int)Math.sqrt(max)+1; i++) {
            if(sieve[i]) {
                for(int j=2*i; j<max; j+=i) sieve[j] = false;
            }
        }

        q = new ArrayList<>();
        for(int i=2; i<max; i++) if(sieve[i]) q.add((long)i);

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long z = x+y;
            if(z < 4) sb.append("NO\n");
            else if(z%2 == 0) sb.append("YES\n");
            else {
                z -= 2;
                sb.append((chk(z)) ? "YES\n" : "NO\n");
            }
        }

        bw.write(sb.toString());
    }

    private static boolean chk(long x) {
        for(int i=0; i<q.size(); i++) {
            if(q.get(i)*q.get(i) > x) break;
            if(x%q.get(i) == 0) return false;
        }
        return true;
    }

}
