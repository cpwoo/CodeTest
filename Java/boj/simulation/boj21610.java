package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj21610 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,-1,-1,-1,0,1,1,1};
    private static final int[] dy = {-1,-1,0,1,1,1,0,-1};
    private static final int[] cx = {-1,-1,1,1}, cy = {-1,1,-1,1};

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

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] moves = new int[m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i][0] = Integer.parseInt(st.nextToken())-1;
            moves[i][1] = Integer.parseInt(st.nextToken());
        }

        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n-2, 0});
        clouds.add(new int[]{n-2, 1});
        clouds.add(new int[]{n-1, 0});
        clouds.add(new int[]{n-1, 1});

        List<int[]> nextClouds = new ArrayList<>();

        for(int t=0; t<m; t++) {
            int[] move = moves[t];
            nextClouds.clear();

            for(int[] cloud : clouds) {
                int x = cloud[0], y = cloud[1];
                int d = move[0], s = move[1];

                int nx = (n+(x+dx[d]*s)%n)%n;
                int ny = (n+(y+dy[d]*s)%n)%n;
                
                nextClouds.add(new int[]{nx, ny});
            }

            boolean[][] visited = new boolean[n][n];
            for(int[] cloud : nextClouds) {
                int x = cloud[0], y = cloud[1];
                arr[x][y]++;
                visited[x][y] = true;
            }

            clouds.clear();

            for(int[] cloud : nextClouds) {
                int x = cloud[0], y = cloud[1];
                int cnt = 0;
                for(int d=0; d<4; d++) {
                    int nx = x+cx[d], ny = y+cy[d];

                    if(0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] >= 1) {
                        cnt++;
                    }
                }

                arr[x][y] += cnt;
            }

            for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
                if(arr[i][j] >= 2 && !visited[i][j]) {
                    arr[i][j] -= 2;
                    clouds.add(new int[]{i, j});
                }
            }
        }

        int ret = 0;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) ret += arr[i][j];

        bw.write(ret+"");
    }

}
