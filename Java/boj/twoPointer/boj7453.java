package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj7453 {
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
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][4];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n*n], cd = new int[n*n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ab[i*n+j] = arr[i][0]+arr[j][1];
                cd[i*n+j] = arr[i][2]+arr[j][3];
            }
        }

        Arrays.sort(ab); Arrays.sort(cd);

        int left = 0, right = n*n-1;
        long ret = 0;
        while(left < n*n && right >= 0) {
            if(ab[left]+cd[right] == 0) {
                int nleft = left+1, nright = right-1;
                long lcnt = 1, rcnt = 1;
                
                while(nleft < n*n && ab[left] == ab[nleft]) {
                    nleft++;
                    lcnt++;
                }
                
                while(nright >= 0 && cd[right] == cd[nright]) {
                    nright--;
                    rcnt++;
                }

                ret += lcnt*rcnt;

                left = nleft; right = nright;
            }
            else if(ab[left]+cd[right] > 0) right--;
            else left++;
        }

        bw.write(ret+"");
    }

}
