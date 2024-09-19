package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj11559 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static char data[][];
    private static boolean visited[][];
    private static List<int[]> tmp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        data = new char[12][6];
        for(int i=0; i<12; i++) data[i] = br.readLine().toCharArray();

        int time = 0;
        while(true) {
            boolean flag = false;
            visited = new boolean[12][6];

            for(int i=0; i<12; i++) for(int j=0; j<6; j++) {
                if(data[i][j] != '.' && !visited[i][j]) {
                    visited[i][j] = true;
                    tmp = new ArrayList<>();
                    bfs(i, j);
                    if(tmp.size() >= 4) {
                        flag = true;
                        delete();
                    }
                }
            }

            if(!flag) break;
            down();
            time++;
        }

        bw.write(time+"");
    }

    private static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        tmp.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0]; y = cur[1];
            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < 12 && 0 <= ny && ny < 6) {
                    if(data[nx][ny] == data[x][y] && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        tmp.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void delete() {
        for(int[] cur : tmp) {
            data[cur[0]][cur[1]] = '.';
        }
    }

    private static void down() {
        for(int i=0; i<6; i++) for(int j=10; j>=0; j--) for(int k=11; k>j; k--) {
            if(data[j][i] != '.' && data[k][i] == '.') {
                data[k][i] = data[j][i];
                data[j][i] = '.';
                break;
            }
        }
    }

}
