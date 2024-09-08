package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1939 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<int[]> graph[];
    private static int start, end;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int min = 1, max = 1_000_000_000;

        int ret = 1;
        while(min <= max) {
            int mid = (min+max)/2;
            if(bfs(mid)) {
                ret = mid;
                min = mid+1;
            }
            else max = mid-1;
        }
        
        bw.write(ret+"");
    }

    private static boolean bfs(int m) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        Set<Integer> v = new HashSet<>();
        v.add(start);

        while(!q.isEmpty()) {
            int x = q.poll();
            for(int[] nxt : graph[x]) {
                int y = nxt[0], w = nxt[1];
                if(!v.contains(y) && w >= m) {
                    v.add(y);
                    q.add(y);
                }
            }
        }

        return v.contains(end);
    }

}
