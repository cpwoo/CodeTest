package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1456 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int L = (int) Math.sqrt(B)+1;

        boolean[] sieve = new boolean[L];
        Arrays.fill(sieve, true);

        sieve[0] = sieve[1] = false;
        for(int i=2; i<(int)Math.sqrt(L)+1; i++) {
            if(sieve[i]) {
                for(int j=i*i; j<L; j+=i) sieve[j] = false;
            }
        }

        long cnt =0;
		for (int i=2; i<L; i++) {
			if(sieve[i]) {
				long tmp = i;
				while ((double) i <= (double)B/(double)tmp) {
                    if ((double) i >= (double)A/(double)tmp) {
                        cnt++;
                    }
                    tmp *= i;
                }
			}
			
		}

        bw.write(cnt+"");
    }

}
