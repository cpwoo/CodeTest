import java.io.*;
import java.util.*;

class Node {
    int rx; int ry; int bx; int by; int depth;

    Node(int rx, int ry, int bx, int by, int depth) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
    }
}

public class 구슬탈출2 {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    static char[][] req;
    static boolean[][][][] visited;
    static int rx, ry, bx, by;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        req = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                req[i][j] = str.charAt(j);
                if (req[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (req[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(rx, ry, bx, by, 1));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.depth > 10) break;
            for (int d=0; d<4; d++) {
                int[] nr = move(node.rx, node.ry, d);
                int nrx = nr[0], nry = nr[1], rcnt = nr[2];
                int[] nb = move(node.bx, node.by, d);
                int nbx = nb[0], nby = nb[1], bcnt = nb[2];

                if (req[nbx][nby] != 'O') {
                    if (req[nrx][nry] == 'O') {
                        System.out.println(node.depth);
                        return;
                    }
                    if (nrx == nbx && nry == nby) {
                        if (rcnt > bcnt) {
                            nrx -= dx[d]; nry -= dy[d];
                        }
                        else {
                            nbx -= dx[d]; nby -= dy[d];
                        }
                    }
                    if (!visited[nrx][nry][nbx][nby]) {
                        visited[nrx][nry][nbx][nby] = true;
                        q.add(new Node(nrx, nry, nbx, nby, node.depth+1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static int[] move(int x, int y, int p) {
        int cnt = 0;
        while (req[x+dx[p]][y+dy[p]] != '#') {
            x += dx[p]; y += dy[p]; cnt++;
            if (req[x][y] == 'O') break;
        }
        return new int[]{x, y, cnt};
    }
}
