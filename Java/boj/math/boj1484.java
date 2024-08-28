package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1484 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<Integer> ret = new ArrayList<>();
        for(int i=1; i<(int)Math.sqrt(n)+1; i++) {
            if(n%i != 0) continue;

            int p1 = i, p2 = n/i;

            if(p1 == 0 || p2 == 0) continue;

            if(p1 == p2 || (p1+p2)%2 == 1) continue;

            ret.add((p1+p2)/2);
        }

        if(ret.isEmpty()) ret.add(-1);

        Collections.sort(ret);

        sb = new StringBuilder();
        for(int i=0; i<ret.size(); i++) sb.append(ret.get(i)).append('\n');

        bw.write(sb.toString());
    }

}
