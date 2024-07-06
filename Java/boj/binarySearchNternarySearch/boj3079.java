package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj3079 {
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
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        long[] time = new long[n];
        for(int i=0; i<n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }


        long start = 0, end = 1_000_000_000L*1_000_000_000L;

        while(start <= end) {
            long mid = (start+end)/2;
            long total = 0;
            
            for(int i=0; i<n; i++) {
                if(total >= m) break;
                total += mid/time[i];
            }

            if(total >= m) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        bw.write(start+"");
    }

}
