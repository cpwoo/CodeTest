package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj21315 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        int[] goal = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        int lim = (int)(Math.log(n)/Math.log(2));
        for(int k1=1; k1<=lim; k1++) {
            for(int k2=1; k2<=lim; k2++) {
                int[] tmp = new int[n];
                for(int j=0; j<n; j++) {
                    tmp[j] = arr[j];
                }
                shuffle(k1, tmp);
                shuffle(k2, tmp);
                if(equals(tmp, goal)) {
                    bw.write(k1+" "+k2+"");
                    return;
                }
            }
        }
    }

    private static void shuffle(int k, int[] tmp) {
        int pos = n;
        for(int i=1; i<=k+1; i++) {
            int[] nxt = new int[n];
            int up = (1<<(k-i+1));
            int idx = 0;
            for(int j=pos-up; j<pos; j++) {
                nxt[idx] = tmp[j];
                idx++;
            }
            for(int j=0; j<pos-up; j++) {
                nxt[idx] = tmp[j];
                idx++;
            }
            for(int j=pos; j<n; j++) {
                nxt[idx] = tmp[j];
                idx++;
            }
            for(int j=0; j<n; j++) {
                tmp[j] = nxt[j];
            }
            pos = up;
        }
    }

    private static boolean equals(int[] tmp, int[] arr) {
        for(int i=0; i<n; i++) {
            if(tmp[i] != arr[i]) return false;
        }
        return true;
    }

}
