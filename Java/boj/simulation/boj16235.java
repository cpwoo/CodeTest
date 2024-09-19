package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj16235 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    private static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    private static int N, a[][], land[][];
    private static List<Integer> trees[][];

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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        a = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        land = new int[N][N];
        for(int i=0; i<N; i++) Arrays.fill(land[i], 5);

        trees = new ArrayList[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            trees[i][j] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees[x-1][y-1].add(z);
        }

        for(int i=0; i<K; i++) {
            springSummer();
            fallWinter();
        }

        int ret = 0;
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            ret += trees[i][j].size();
        }

        bw.write(ret+"");
    }

    private static void springSummer() {
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            List<Integer> newTrees = new ArrayList<>();
            int deadNutrients = 0;

            for(int k=0; k<trees[i][j].size(); k++) {
                int age = trees[i][j].get(k);
                if(age <= land[i][j]) {
                    land[i][j] -= age;
                    newTrees.add(age+1);
                }
                else deadNutrients += age/2;
            }
            land[i][j] += deadNutrients;
            trees[i][j] = newTrees;
        }
    }

    private static void fallWinter() {
        for(int x=0; x<N; x++) for(int y=0; y<N; y++) {
            for(int age : trees[x][y]) {
                if(age%5 == 0) {
                    for(int d=0; d<8; d++) {
                        int nx = x+dx[d], ny = y+dy[d];
                        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                            trees[nx][ny].add(0, 1);
                        }
                    }
                }
            }
            land[x][y] += a[x][y];
        }
    }

}
