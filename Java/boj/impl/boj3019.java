package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj3019 {
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
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] height = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;

        switch(P) {
            case 1: {
                ret += C;
                for(int i=0; i<C-3; i++) {
                    if(height[i] == height[i+1] && height[i+1] == height[i+2] && height[i+2] == height[i+3]) ret++;
                }
                break;
            }
            case 2: {
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]) ret++;
                }
                break;
            }
            case 3: {
                for(int i=0; i<C-2; i++) {
                    if(height[i] == height[i+1] && height[i+1] == height[i+2]-1) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]+1) ret++;
                }
                break;
            }
            case 4: {
                for(int i=0; i<C-2; i++) {
                    if(height[i] == height[i+1]+1 && height[i+1] == height[i+2]) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]-1) ret++;
                }
                break;
            }
            case 5: {
                for(int i=0; i<C-2; i++) {
                    if(height[i] == height[i+1] && height[i+1] == height[i+2]) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]+1 && height[i+1] == height[i+2]-1) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]-1) ret++;
                    if(height[i] == height[i+1]+1) ret++;
                }
                break;
            }
            case 6: {
                for(int i=0; i<C-2; i++) {
                    if(height[i] == height[i+1] && height[i+1] == height[i+2]) ret++;
                    if(height[i] == height[i+1]-1 && height[i+1] == height[i+2]) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]) ret++;
                    if(height[i] == height[i+1]+2) ret++;
                }
                break;
            }
            case 7: {
                for(int i=0; i<C-2; i++) {
                    if(height[i] == height[i+1] && height[i+1] == height[i+2]) ret++;
                    if(height[i] == height[i+1] && height[i+1] == height[i+2]+1) ret++;
                }
                for(int i=0; i<C-1; i++) {
                    if(height[i] == height[i+1]-2) ret++;
                    if(height[i] == height[i+1]) ret++;
                }
            }
        }

        bw.write(ret+"");
    }

}
