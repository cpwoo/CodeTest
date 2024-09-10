package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2842 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,0,-1,0,-1,1,1,-1};
    private static final int[] dy = {0,1,0,-1,1,1,-1,-1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        int[][] tiredness = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) tiredness[i][j] = Integer.parseInt(st.nextToken());
        }

        int houses = 0;
        Set<Integer> set = new HashSet<>();
        int sx = -1, sy = -1;

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(board[i][j] == 'P') {
                sx = i; sy = j;
            }
            else if(board[i][j] == 'K') houses++;
            set.add(tiredness[i][j]);
        }

        List<Integer> fatigue = new ArrayList<>(set);
        Collections.sort(fatigue);

        Deque<int[]> q = new ArrayDeque<>();
        int left = 0, right = 0;
        int ret = Integer.MAX_VALUE;
        
        while(left < fatigue.size()) {
            boolean[][] visited = new boolean[n][n];
            int tired = tiredness[sx][sy];
            int k = 0;

            if(fatigue.get(left) <= tired && tired <= fatigue.get(right)) {
                visited[sx][sy] = true;
                q.add(new int[]{sx, sy});
            }

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int d=0; d<8; d++) {
                    int nx = x+dx[d], ny = y+dy[d];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if(visited[nx][ny]) continue;
                        tired = tiredness[nx][ny];
                        if(fatigue.get(left) <= tired && tired <= fatigue.get(right)) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            if(board[nx][ny] == 'K') k++;
                        }
                    }
                }
            }

            if(k == houses) {
                ret = Math.min(ret, fatigue.get(right)-fatigue.get(left));
                left++;
            }
            else if(right+1 < fatigue.size()) right++;
            else break;
        }

        bw.write(ret+"");
    }

}
