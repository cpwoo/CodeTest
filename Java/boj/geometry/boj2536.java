package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2536 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

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

        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[k+1][4];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[a][0] = Math.min(b, d);
            arr[a][1] = Math.min(c, e);
            arr[a][2] = Math.max(b, d);
            arr[a][3] = Math.max(c, e);
        }

        boolean[] check = new boolean[k+1];
        for(int i=1; i<k+1; i++) {
            boolean tmp = false;
            for(int j=1; j<k+1; j++) {
                if(i == j) continue;
                if((arr[i][0] == arr[j][0]) && (arr[j][0] == arr[i][2]) && (arr[i][2] == arr[j][2])) {
                    if((arr[j][1] <= arr[i][1]) && (arr[i][1] <= arr[i][3]) && (arr[i][3] <= arr[j][3])) {
                        tmp = true;
                    }
                }

                if((arr[i][1] == arr[j][1]) && (arr[j][1] == arr[i][3]) && (arr[i][3] == arr[j][3])) {
                    if((arr[j][0] <= arr[i][0]) && (arr[i][0] <= arr[i][2]) && (arr[i][2] <= arr[j][2])) {
                        tmp = true;
                    }
                }
            }
            check[i] = tmp;
        }

        List<Integer> adj[] = new ArrayList[k+1];
        for(int i=0; i<k+1; i++) adj[i] = new ArrayList<>();
        
        for(int i=1; i<k+1; i++) {
            if(check[i]) continue;
            for(int j=1; j<k+1; j++) {
                if(check[j] || i == j) continue;
                
                if((arr[i][0] <= arr[j][0] && arr[j][0] <= arr[i][2]) && (arr[i][0] <= arr[j][2] && arr[j][2] <= arr[i][2])) {
                    if((arr[j][1] <= arr[i][1] && arr[i][1] <= arr[j][3]) && (arr[j][1] <= arr[i][3] && arr[i][3] <= arr[j][3])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }

                if((arr[i][0] == arr[j][0]) && (arr[j][0] == arr[i][2]) && (arr[i][2] == arr[j][2])) {
                    if(!(arr[i][1] > arr[j][3] || arr[i][3] < arr[j][1])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }

                if((arr[i][1] == arr[j][1]) && (arr[j][1] == arr[i][3]) && (arr[i][3] == arr[j][3])) {
                    if(!(arr[i][0] > arr[j][2] || arr[i][2] < arr[j][0])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(int i=1; i<k+1; i++) {
            if(check[i]) continue;
            if((arr[i][0] <= sx && sx <= arr[i][2]) && (arr[i][1] <= sy && sy <= arr[i][3])) {
                start.add(i);
            }
            if((arr[i][0] <= ex && ex <= arr[i][2]) && (arr[i][1] <= ey && ey <= arr[i][3])) {
                end.add(i);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        int[] v = new int[k+1];
        Arrays.fill(v, -1);

        for(Integer i : start) {
            q.add(i);
            v[i] = 0;
        }

        while(!q.isEmpty()) {
            int now = q.pollFirst();
            for(Integer nxt : adj[now]) {
                if(v[nxt] == -1) {
                    v[nxt] = v[now]+1;
                    q.add(nxt);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(Integer i : end) ret = Math.min(ret, v[i]);

        bw.write(ret+1+"");
    }

}
