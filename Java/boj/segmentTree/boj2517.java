package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2517 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static int n, tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        List<int[]> info = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            info.add(new int[]{x, i+1});
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        };

        Collections.sort(info, comp);

        for(int i=0; i<n; i++) {
            info.get(i)[0] = i+1;
            int tmp = info.get(i)[0];
            info.get(i)[0] = info.get(i)[1];
            info.get(i)[1] = tmp;
        }

        Collections.sort(info, comp);

        tree = new int[500005];
        
        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int tmp = info.get(i)[1];
            sb.append((i+1)-query(tmp-1)).append('\n');
            update(tmp, 1);
        }

        bw.write(sb.toString());
    }

    private static int query(int i) {
        int ans = 0;
        while(i > 0) {
            ans += tree[i];
            i -= (i&-i);
        }
        return ans;
    }

    private static void update(int i, int num) {
        while(i <= n) {
            tree[i] += num;
            i += (i&-i);
        }
    }

}
