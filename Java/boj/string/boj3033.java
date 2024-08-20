package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj3033 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int MOD = 100003;
    private static int n;
    private static char[] arr;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        int left = 0, right = n;
        while(left+1 < right) {
            int mid = (left+right)/2;
            if(chk(mid)) left = mid;
            else right = mid;
        }

        bw.write(left+"");
    }

    private static boolean chk(int mid) {
        List<Integer> pos[] = new ArrayList[MOD];
        for(int i=0; i<MOD; i++) pos[i] = new ArrayList<>();

        int h = 0, power = 1;

        for(int i=0; i<n-mid+1; i++) {
            if(i == 0) {
                for(int j=0; j<mid; j++) {
                    h = mod(h+arr[mid-1-j]*power);
                    if(j < mid-1) power = mod(power<<1);
                }
            }
            else {
                h = mod(2*(h-arr[i-1]*power)+arr[i+mid-1]);
            }

            if(!pos[h].isEmpty()) {
                for(Integer p : pos[h]) {
                    boolean flag = true;
                    for(int j=0; j<mid; j++) {
                        if(arr[i+j] != arr[p+j]) {
                            flag = false; break;
                        }
                    }
                    if(flag) return true;
                }
            }
            pos[h].add(i);
        }

        return false;
    }

    private static int mod(double d) {
		double tmp = d%MOD;
		return (tmp >= 0) ? (int)tmp : (int)tmp+MOD;
	}

}
