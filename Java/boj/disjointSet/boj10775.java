package CodeTest.Java.boj.disjointSet;

import java.io.*;

public class boj10775 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int p[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        p = new int[G+1];
        for(int i=0; i<G+1; i++) p[i] = i;

        int[] planes = new int[P];
        for(int i=0; i<P; i++) {
            planes[i] = Integer.parseInt(br.readLine());
        }

        int ret = 0;
        for(int plane: planes) {
            int docking = find(plane);
            if(docking == 0) break;
            p[docking] = p[docking-1];
            ret++;
        }

        bw.write(ret+"");
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

}
