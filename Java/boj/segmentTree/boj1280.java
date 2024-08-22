package CodeTest.Java.boj.segmentTree;

import java.io.*;

public class boj1280 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int max = 200_000, mod = 1_000_000_007;
    private static long treeCnt[], treeDist[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        treeCnt = new long[max+1];
        treeDist = new long[max+1];
        
        long ans = 1;
        for(int i=0; i<n; i++) {
            long tmp = 0;
            int t = Integer.parseInt(br.readLine())+1;
            if(i == 0) {
                updateCnt(t, 1);
                updateDist(t, t);
            }
            else {
                tmp = MOD(tmp+(queryCnt(t-1)*t)-(queryDist(t-1)));
                tmp = MOD(tmp+(queryDist(max)-queryDist(t))-(queryCnt(max)-queryCnt(t))*t);
                updateCnt(t, 1);
                updateDist(t, t);
                ans = MOD(ans*tmp);
            }
        }

        bw.write(MOD(ans)+"");
    }

    private static void updateCnt(int target, int value) {
        while(target <= max) {
            treeCnt[target] += value;
            target += (target&-target);
        }
    }

    private static void updateDist(int target, int value) {
        while(target <= max) {
            treeDist[target] += value;
            target += (target&-target);
        }
    }

    private static long queryCnt(int target) {
        long ret = 0;
        while(target >= 1) {
            ret += treeCnt[target];
            target -= (target&-target);
        }
        return ret;
    }

    private static long queryDist(int target) {
        long ret = 0;
        while(target >= 1) {
            ret += treeDist[target];
            target -= (target&-target);
        }
        return ret;
    }

    private static long MOD(long tmp) {
        long ret = tmp%mod;
        return (ret >= 0) ? ret : ret+mod;
    }

}
