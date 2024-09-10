package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj2665 {
    static class Road implements Comparable<Road> {
        int x, y, d;
        Road(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        
        @Override
        public int compareTo(Road o) {
            if(this.d != o.d) return this.d-o.d;
            else if(this.x != o.x) return this.x-o.x;
            return this.y-o.y;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n;
    private static char arr[][];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        
        arr = new char[n][n];
        for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();

        visited = new boolean[n][n];

        bw.write(dijkstra()+"");
    }

    private static int dijkstra() {
        Queue<Road> q = new PriorityQueue<>();
        q.add(new Road(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Road road = q.poll();
            if(road.x == n-1 && road.y == n-1) return road.d;

            for(int i=0; i<4; i++) {
                int nx = road.x+dx[i], ny = road.y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(arr[nx][ny] == '0') q.add(new Road(nx, ny, road.d+1));
                    else q.add(new Road(nx, ny, road.d));
                }
            }
        }

        return -1;
    }

}
