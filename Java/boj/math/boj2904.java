package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2904 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int max = 1_000_001;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[max];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for(int i=2; i<(int)Math.sqrt(max)+1; i++) {
            if(sieve[i]) {
                for(int j=2*i; j<max; j+=i) sieve[j] = false;
            }
        }

        List<Integer> prime = new ArrayList<>();
        for(int i=2; i<max; i++) if(sieve[i]) prime.add(i);

        int[] whole = new int[max];
        int[][] pf = new int[n][prime.size()];

        for(int i=0; i<n; i++) for(int j=0; j<prime.size(); j++) {
            if(arr[i] == 1) break;
            while(arr[i]%prime.get(j) == 0) {
                arr[i] /= prime.get(j);
                whole[prime.get(j)]++;
                pf[i][j]++;
            }
        }

        int[] ans = new int[]{1, 0};

        for(int j=0; j<prime.size(); j++) {
            int tmp = whole[prime.get(j)]/n;
            int cnt = 0;
            for(int i=0; i<n; i++) {
                if(tmp > pf[i][j]) cnt += tmp-pf[i][j];
            }
            ans[0] *= Math.pow(prime.get(j), tmp);
            ans[1] += cnt;
        }

        bw.write(ans[0]+" "+ans[1]+"");
    }

}
