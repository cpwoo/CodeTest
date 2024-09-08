package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1525 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    private static final String answer = "123456780";

    private static Map<String, Integer> map;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        StringBuilder inp = new StringBuilder();
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) inp.append(st.nextToken());
        }
        String x = inp.toString();

        map = new HashMap<>();
        map.put(x, 0);

        bw.write(bfs(x)+"");
    }

    private static int bfs(String str) {
        Deque<String> q = new ArrayDeque<>();
        q.add(str);
        
        while(!q.isEmpty()) {
            String puzzle = q.poll();
            int cnt = map.get(puzzle);
            int z = puzzle.indexOf('0');
            
            int x = z/3, y = z%3;

            if(puzzle.equals(answer)) return cnt;

            for(int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if(0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
                    int nz = 3*nx+ny;
                    char ch = puzzle.charAt(nz);
                    String nxt = puzzle.replace(ch, 'c');
                    nxt = nxt.replace('0', ch);
                    nxt = nxt.replace('c', '0');

                    if(!map.containsKey(nxt)) {
                        q.add(nxt);
                        map.put(nxt, cnt+1);
                    }
                }
            }
        }

        return -1;
    }

}
