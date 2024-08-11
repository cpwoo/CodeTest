package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2261 {
    static Comparator<int[]> Xcomp = new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    };

    static Comparator<int[]> Ycomp = new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1];
        }
    };

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[][] points;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        points = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(points, Xcomp);

        bw.write(closestPair(0, n-1)+"");
    }

    private static int dist(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }

    private static int closestPair(int start, int end) {
        if(start == end) return Integer.MAX_VALUE;

        if(end-start == 1) return dist(points[start], points[end]);

        int mid = (start+end)/2;
        int min = Math.min(closestPair(start, mid), closestPair(mid+1, end));

        List<int[]> can = new ArrayList<>();
        for(int i=start; i<end+1; i++) {
            if((points[mid][0]-points[i][0])*(points[mid][0]-points[i][0]) <= min) {
                can.add(points[i]);
            }
        }

        Collections.sort(can, Ycomp);

        int c = can.size();
        for(int i=0; i<c-1; i++) for(int j=i+1; j<c; j++) {
            if((can.get(i)[1]-can.get(j)[1])*(can.get(i)[1]-can.get(j)[1]) < min) {
                min = Math.min(min, dist(can.get(i), can.get(j)));
            }
            else break;
        }

        return min;
    }

}
