package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj18809 {
    static class Node {
        int x, y, color;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.color = 0;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    private static int N, M, board[][], sz, ret, chk[][];
    private static List<Node> location;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        location = new ArrayList<>();
        sz = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    location.add(new Node(i, j));
                    sz++;
                }
            }
        }
        
        ret = 0;
        
        select(0, G, R);

        bw.write(ret+"");
    }

    private static void select(int cur, int green, int red) {
        if(cur == sz) {
            if(green != 0 || red != 0) return;

            chk = new int[N][M];
            for(int i=0; i<sz; i++) {
                Node node = location.get(i);
                if(node.color > 0) {
                    chk[node.x][node.y] = 10+node.color;
                }
            }

            int sum = 0;
            Deque<Integer> q = new ArrayDeque<>();
            for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
                if(chk[i][j]/10 == 1) {
                    q.add(i); q.add(j);
                }
            }

            while(!q.isEmpty()) {
                int x = q.poll(), y = q.poll();
                int time = chk[x][y]/10, color = chk[x][y]%10;

                if(chk[x][y] == -1) continue;

                for(int d=0; d<4; d++) {
                    int nx = x+dx[d], ny = y+dy[d];
                    if(0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] != 0 && chk[nx][ny] != -1) {
                        if(chk[nx][ny] == 0) {
                            chk[nx][ny] = 10*(time+1)+color;
                            q.add(nx); q.add(ny);
                        }
                        else {
                            if(chk[nx][ny]/10 == time+1 && chk[nx][ny]%10 != color) {
                                chk[nx][ny] = -1;
                                sum++;
                            }
                        }
                    }
                }
            }

            ret = Math.max(ret, sum);
            return;
        }

        if(green > 0) {
            location.get(cur).color = 1;
            select(cur+1, green-1, red);
        }

        if(red > 0) {
            location.get(cur).color = 2;
            select(cur+1, green, red-1);
        }

        location.get(cur).color = 0;
        select(cur+1, green, red);
    }

}
