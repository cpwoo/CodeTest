package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14867 {
    static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return x == info.x && y == info.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Set<Info> visited = new HashSet<>();
        visited.add(new Info(0, 0));

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cnt = cur[0], x = cur[1], y = cur[2];

            if(x == c && y == d) {
                bw.write(cnt+"");
                return;
            }

            Info info = new Info(a, y);

            if(x < a && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, a, y});
            }

            info = new Info(x, b);

            if(y < b && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, x, b});
            }

            info = new Info(0, y);

            if(x != 0 && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, 0, y});
            }

            info = new Info(x, 0);

            if(y != 0 && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, x, 0});
            }

            int k = Math.min(x, b-y);
            info = new Info(x-k, y+k);

            if(x != 0 && k != 0 && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, x-k, y+k});
            }

            k = Math.min(y, a-x);
            info = new Info(x+k, y-k);

            if(y != 0 && k != 0 && !visited.contains(info)) {
                visited.add(info);
                q.add(new int[]{cnt+1, x+k, y-k});
            }
        }

        bw.write("-1");
    }

}
