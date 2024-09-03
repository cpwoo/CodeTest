package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj21608 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];

        int[][] students = new int[n*n][5];
        for(int i=0; i<n*n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) students[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int order=0; order<n*n; order++) {
            int[] student = students[order];

            List<int[]> tmp = new ArrayList<>();

            for(int i=0; i<n; i++) for(int j=0; j<n; j++) if(arr[i][j] == 0) {
                int like = 0, blank = 0;
                for(int k=0; k<4; k++) {
                    int nr = i+dr[k], nc = j+dc[k];
                    if(0 <= nr && nr < n && 0 <= nc && nc < n) {
                        boolean flag = false;
                        for(int l=1; l<5; l++) if(student[l] == arr[nr][nc]) {
                            flag = true;
                            break;
                        }
                        if(flag) like++;

                        if(arr[nr][nc] == 0) blank++;
                    }
                }
                tmp.add(new int[]{like, blank, i, j});
            }

            Collections.sort(tmp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]) return o2[0]-o1[0];
                    else if(o1[1] != o2[1]) return o2[1]-o1[1];
                    else if(o1[2] != o2[2]) return o1[2]-o2[2];
                    return o1[3]-o2[3]; 
                }
            });

            arr[tmp.get(0)[2]][tmp.get(0)[3]] = student[0];
        }

        Arrays.sort(students, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i=0; i<5; i++) {
                    if(o1[i] != o2[i]) return o1[i]-o2[i];
                }
                return 0;
            }
        });

        int ret = 0;

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            int ans = 0;
            for(int k=0; k<4; k++) {
                int nr = i+dr[k], nc = j+dc[k];
                if(0 <= nr && nr < n && 0 <= nc && nc < n) {
                    boolean flag = false;
                    for(int l=0; l<5; l++) if(students[arr[i][j]-1][l] == arr[nr][nc]) {
                        flag = true;
                        break;
                    }
                    if(flag) ans++;
                }
            }
            if(ans != 0) ret += Math.pow(10, ans-1);
        }

        bw.write(ret+"");
    }

}
