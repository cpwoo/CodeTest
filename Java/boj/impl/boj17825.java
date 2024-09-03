package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj17825 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] score = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,13,16,19,25,22,24,28,27,26,30,35,0};
    
    private static List<List<Integer>> graph;
    private static int dice[], ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();

        dice = new int[10];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++) dice[i] = Integer.parseInt(st.nextToken());

        ret = 0;

        dfs(new int[4], 0, 0);
        
        bw.write(ret+"");

        bw.flush();
        bw.close();
    }

    private static void init() {
        graph = new ArrayList<>();

        graph.add(Arrays.asList(1)); graph.add(Arrays.asList(2)); graph.add(Arrays.asList(3));
        graph.add(Arrays.asList(4)); graph.add(Arrays.asList(5)); graph.add(Arrays.asList(6, 21));
        graph.add(Arrays.asList(7)); graph.add(Arrays.asList(8)); graph.add(Arrays.asList(9));
        graph.add(Arrays.asList(10)); graph.add(Arrays.asList(11, 25)); graph.add(Arrays.asList(12));
        graph.add(Arrays.asList(13)); graph.add(Arrays.asList(14)); graph.add(Arrays.asList(15));
        graph.add(Arrays.asList(16, 27)); graph.add(Arrays.asList(17)); graph.add(Arrays.asList(18));
        graph.add(Arrays.asList(19)); graph.add(Arrays.asList(20)); graph.add(Arrays.asList(32));
        graph.add(Arrays.asList(22)); graph.add(Arrays.asList(23)); graph.add(Arrays.asList(24));
        graph.add(Arrays.asList(30)); graph.add(Arrays.asList(26)); graph.add(Arrays.asList(24));
        graph.add(Arrays.asList(28)); graph.add(Arrays.asList(29)); graph.add(Arrays.asList(24));
        graph.add(Arrays.asList(31)); graph.add(Arrays.asList(20)); graph.add(Arrays.asList(32));
    }

    private static void dfs(int[] horses, int sum, int depth) {
        if(depth == 10) {
            ret = Math.max(ret, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int x = horses[i];
            if(graph.get(x).size() == 2) x = graph.get(x).get(1);
            else x = graph.get(x).get(0);

            for(int j=1; j<dice[depth]; j++) x = graph.get(x).get(0);

            if(x == 32 || (x < 32 && (horses[0] != x && horses[1] != x && horses[2] != x && horses[3] != x))) {
                int tmp = horses[i];
                horses[i] = x;
                dfs(horses, sum+score[x], depth+1);
                horses[i] = tmp;
            }
        }
    }

}
