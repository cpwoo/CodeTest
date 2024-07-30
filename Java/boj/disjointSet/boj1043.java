package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj1043 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for(int i=0; i<n+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        for(int i=0; i<c; i++) {
            int x = Integer.parseInt(st.nextToken());
            parent[x] = 0;
        }

        List<int[]> parties = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int[] party = new int[d];
            for(int j=0; j<d; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<d-1; j++) {
                union(party[j], party[j+1]);
            }
            parties.add(party);
        }

        int ret = 0;

        for(int[] party: parties) {
            boolean flag = true;
            for(int i=0; i<party.length; i++) {
                if(find(party[i]) == 0) {
                    flag = false;
                    break;
                }
            }
            ret += flag ? 1: 0;
        }

        bw.write(ret+"");
    }


    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

}
