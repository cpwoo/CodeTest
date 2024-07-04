package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj1561 {
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
        
        inp = br.readLine().split(" ");
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        if(n <= m) {
            bw.write(n+"");
        } else {
            long left, right, mid, cnt;
            long t = 0;

            left = 0; right = 60_000_000_000L;
            while(left <= right) {
                mid = (left+right)/2;
                cnt = m;
                for(int i=0; i<m; i++) {
                    cnt += mid/arr[i];
                }
                if(cnt >= n) {
                    t = mid;
                    right = mid-1L;
                } else {
                    left = mid+1L;
                }
            }

            cnt = m;
            for(int i=0; i<m; i++) {
                cnt += (t-1)/arr[i];
            }

            for(int i=0; i<m; i++) {
                if(t%arr[i] == 0) {
                    cnt++;
                }
                if(cnt == n) {
                    bw.write(i+1+"");
                    break;
                }
            }
        }
    }

}
