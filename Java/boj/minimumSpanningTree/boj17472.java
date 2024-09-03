package CodeTest.Java.boj.minimumSpanningTree;

import java.io.*;
import java.util.*;

public class boj17472 {
    static class Node implements Comparable<Node> {
        int u, v, w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
            else if(this.u != node.u) return this.u-node.u;
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};

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

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visited = new boolean[n][m];

        int[][] land = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(land[i], -1);
        
        int landNum = 0;

        List<int[]> lst = new ArrayList<>();
        Deque<int[]> q;
        
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(board[i][j] == 1 && !visited[i][j]) {
                q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                land[i][j] = landNum;
                lst.add(new int[]{i, j, landNum});

                while(!q.isEmpty()) {
                    int x = q.peek()[0], y = q.peek()[1];
                    q.poll();

                    for(int k=0; k<4; k++) {
                        int nx = x+move[k][0], ny = y+move[k][1];
                        if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && board[nx][ny] == 1) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            land[nx][ny] = landNum;
                            lst.add(new int[]{nx, ny, landNum});
                        }
                    }
                }

                landNum++;
            }
        }

        List<Node> nodes = new ArrayList<>();
        for(int[] cur : lst) {
            int x = cur[0], y = cur[1], curLand = cur[2];

            for(int k=0; k<4; k++) {
                int dist = 0;
                int nx = x+move[k][0], ny = y+move[k][1];
                
                while(true) {
                    if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                        int toLand = land[nx][ny];

                        if(curLand == toLand) break;

                        if(toLand == -1) {
                            nx += move[k][0]; ny += move[k][1];
                            dist++;
                            continue;
                        }

                        if(dist < 2) break;

                        nodes.add(new Node(curLand, toLand, dist));
                        break;
                    }
                    else break;
                }
            }
        }

        Collections.sort(nodes);

        parent = new int[landNum];
        for(int i=0; i<landNum; i++) parent[i] = i;

        int ret = 0, cnt = landNum-1, idx = 0;
        while(cnt != 0) {
            if(idx == nodes.size()) {
                bw.write("-1");
                return;
            }
            Node node = nodes.get(idx);
            if(find(node.u) != find(node.v)) {
                union(node.u, node.v);
                ret += node.w;
                cnt--;
            }
            idx++;
        }

        bw.write(ret+"");
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[b] = a;
    }

}
