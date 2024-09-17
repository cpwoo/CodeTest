package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj20166 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dx = {1,0,-1,0,1,1,-1,-1};
    private static final int[] dy = {0,1,0,-1,-1,1,1,-1};

    private static int n, m;
    private static char[][] arr;
    private static Map<String, Integer> map;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();

        map = new HashMap<>();
        List<String> keyList = new ArrayList<>();
        for(int i=0; i<k; i++) {
            String inp = br.readLine();
            map.put(inp, 0);
            keyList.add(inp);
        }

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            dfs(i, j, 1, new StringBuilder().append(arr[i][j]));
        }

        sb = new StringBuilder();

        for(String key : keyList) sb.append(map.get(key)).append('\n');

        bw.write(sb.toString());
    }

    private static void dfs(int x, int y, int cnt, StringBuilder str) {
        if(cnt > 5) return;

        String string = str.toString();

        if(map.containsKey(string)) {
            map.put(string, map.get(string)+1);
        }

        for(int i=0; i<8; i++) {
            int nx = (x+n+dx[i])%n, ny = (y+m+dy[i])%m;
            dfs(nx, ny, cnt+1, new StringBuilder(str).append(arr[nx][ny]));
        }
    }

}
