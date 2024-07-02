package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj17136 {
    private static boolean[][] board;
    private static int[] papers;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new boolean[10][10];
        for(int i=0; i<10; i++) {
            String[] inp = br.readLine().split(" ");
            for(int j=0; j<10; j++) {
                board[i][j] = inp[j].equals("1");
            }
        }

        papers = new int[5];
        answer = 26;

        backtracking(0, 0, 0);

        bw.write((answer != 26) ? answer+"" : "-1");

        bw.flush();
        bw.close();
    }

    private static void backtracking(int y, int x, int cnt) {
        if(y >= 10) {
            answer = Math.min(answer, cnt);
            return;
        }

        if(x >= 10) {
            backtracking(y+1, 0, cnt);
            return;
        }

        if(board[y][x]) {
            for(int k=0; k<5; k++) {
                if(papers[k] == 5) continue;
                if(y+k >= 10 || x+k >= 10) continue;

                if(chk(y, x, k)) {
                    for(int i=y; i<y+k+1; i++) {
                        for(int j=x; j<x+k+1; j++) {
                            board[i][j] = false;
                        }
                    }
                    papers[k]++;

                    backtracking(y, x+k+1, cnt+1);
                    
                    papers[k]--;
                    for(int i=y; i<y+k+1; i++) {
                        for(int j=x; j<x+k+1; j++) {
                            board[i][j] = true;
                        }
                    }
                }
            }
        } else {
            backtracking(y, x+1, cnt);
        }
    }

    private static boolean chk(int y, int x, int size) {
        for(int i=y; i<y+size+1; i++) {
            for(int j=x; j<x+size+1; j++) {
                if(!board[i][j]) return false;
            }
        }
        return true;
    }
        
}
