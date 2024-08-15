package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj20442 {
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
        String str = br.readLine();

        List<Integer> lk = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'K') cnt++;
            else lk.add(cnt);
        }

        List<Integer> rk = new ArrayList<>();
        cnt = 0;
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == 'K') cnt++;
            else rk.add(cnt);
        }

        Collections.reverse(rk);

        int l = 0, r = lk.size()-1;
        int ret = 0;

        while(l <= r) {
            ret = Math.max(ret, r-l+1+2*Math.min(lk.get(l), rk.get(r)));
            if(lk.get(l) < rk.get(r)) l++;
            else r--;
        }

        bw.write(ret+"");
    }

}
