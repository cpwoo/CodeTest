package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj1194 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};

    private static int n, m;
    private static char s[][];
    private static boolean v[][][];
    private static Queue<int[]> q;

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

        q = new LinkedList<>();
        s = new char[n][m];
        v = new boolean[n][m][64];

        for(int i=0; i<n; i++) {
            String a = br.readLine();
            s[i] = a.toCharArray();
            for(int j=0; j<m; j++) {
                if(a.charAt(j) == '0') {
                    q.add(new int[]{i, j, 0, 0});
                    s[i][j] = '.';
                    v[i][j][0] = true;
                }
            }
        }

        bw.write(bfs()+"");
    }

    private static int bfs() {
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1], c = tmp[2], cnt = tmp[3];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && s[nx][ny] != '#' && !v[nx][ny][c]) {
                    if(s[nx][ny] == '.') {
                        v[nx][ny][c] = true;
                        q.add(new int[]{nx, ny, c, cnt+1});
                    } else if(s[nx][ny] == '1') {
                        return cnt+1;
                    } else {
                        if('A' <= s[nx][ny] && s[nx][ny] <= 'Z') {
                            if((c&(1<<(s[nx][ny]-'A'))) != 0) {
                                v[nx][ny][c] = true;
                                q.add(new int[]{nx, ny, c, cnt+1});
                            }
                        }
                        else if('a' <= s[nx][ny] && s[nx][ny] <= 'z') {
                            if(!v[nx][ny][c]) {
                                v[nx][ny][c] = true;
                                q.add(new int[]{nx, ny, c|(1<<(s[nx][ny]-'a')), cnt+1});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}
