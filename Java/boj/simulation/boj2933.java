package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj2933 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};

    private static int n, m;
    private static boolean copy[][];
    private static List<Integer> airGraph[];

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

        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        int shoot = Integer.parseInt(br.readLine());
        
        int[] arr = new int[shoot];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<shoot; i++) arr[i] = n-Integer.parseInt(st.nextToken());

        copy = new boolean[n][m];

        airGraph = new ArrayList[m];

        for(int order=0; order<shoot; order++) {
            int y = arr[order], T = 0;

            if(order%2 == 0) {
                for(int x=0; x<m; x++) {
                    if(board[y][x] == 'x') {
                        board[y][x] = '.';
                        T = 1;
                        break;
                    }
                }
            }
            else {
                for(int x=m-1; x>=0; x--) {
                    if(board[y][x] == 'x') {
                        board[y][x] = '.';
                        T = 1;
                        break;
                    }
                }
            }

            if(T == 1) {
                for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                    copy[i][j] = (board[i][j] == '.');
                }

                for(int col=0; col<m; col++) {
                    if(!copy[n-1][col]) removeMineral(n-1, col);
                }

                airMineral();

                int min = 100;
                for(int i=0; i<m; i++) {
                    for(int j : airGraph[i]) {
                        for(int fj=j+1; fj<n; fj++) {
                            if(board[fj][i] == 'x' && !airGraph[i].contains(fj)) {
                                min = Math.min(min, fj-j-1);
                            }
                        }
                        if(board[n-1][i] == '.') {
                            min = Math.min(min, (n-1)-j);
                        }
                    }
                }

                for(int i=0; i<m; i++) {
                    Collections.sort(airGraph[i], Collections.reverseOrder());
                    for(int j : airGraph[i]) {
                        board[j][i] = '.';
                        board[j+min][i] = 'x';
                    }
                }
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static void removeMineral(int i, int j) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{i, j});

        while(!stk.isEmpty()) {
            int[] node = stk.pop();
            copy[node[0]][node[1]] = true;
            for(int d=0; d<4; d++) {
                int ny = node[0]+dy[d], nx = node[1]+dx[d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!copy[ny][nx]) stk.add(new int[]{ny, nx});
            }
        }
    }

    private static void airMineral() {
        for(int j=0; j<m; j++) airGraph[j] = new ArrayList<>();

        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            if(!copy[i][j]) airGraph[j].add(i);
        }
    }

}
