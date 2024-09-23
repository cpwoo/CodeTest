package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj20056 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    private static final int[] dy = {0,1,1,1,0,-1,-1,-1};

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
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        
        Deque<int[]> a[][] = new ArrayDeque[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            a[i][j] = new ArrayDeque<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new int[]{r-1, c-1});
            a[r-1][c-1].add(new int[]{m, s, d});
        }

        List<int[]> tmp;

        for(int t=0; t<K; t++) {
            int qsz = q.size();
            tmp = new ArrayList<>();
            for(int i=0; i<qsz; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                int asz = a[x][y].size();

                for(int j=0; j<asz; j++) {
                    cur = a[x][y].poll();
                    int m = cur[0], s = cur[1], d = cur[2];
                    int nx = (N+(x+s*dx[d])%N)%N, ny = (N+(y+s*dy[d])%N)%N;
                    
                    q.add(new int[]{nx, ny});
                    tmp.add(new int[]{nx, ny, m, s, d});
                }
            }

            for(int[] cur : tmp) {
                a[cur[0]][cur[1]].add(new int[]{cur[2], cur[3], cur[4]});
            }

            for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
                if(a[i][j].size() > 1) {
                    int nm = 0, ns = 0, odd = 0, even = 0;
                    boolean flag = false;
                    int asz = a[i][j].size();

                    for(int idx=0; idx<asz; idx++) {
                        int[] cur = a[i][j].poll();
                        int m = cur[0], s = cur[1], d = cur[2];
                        
                        nm += m; ns += s;
                        if(idx == 0) {
                            if(d%2 == 0) even = 1;
                            else odd = 1;
                        }
                        else {
                            if(even == 1 && d%2 == 1) flag = true;
                            else if(odd == 1 && d%2 == 0) flag = true;
                        }
                    }

                    nm /= 5; ns /= asz;
                    if(nm != 0) {
                        for(int idx=0; idx<4; idx++) {
                            int nd = (flag) ? 2*idx+1 : 2*idx;
                            a[i][j].add(new int[]{nm, ns, nd});
                        }
                    }
                }
            }
        }

        int ret = 0;
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            while(!a[i][j].isEmpty()) ret += a[i][j].poll()[0];
        }

        bw.write(ret+"");
    }

}
