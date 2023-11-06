package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 블록이동하기 {
    public int solution(int[][] board) {
        int n = board.length;
        
        boolean[][][] visited = new boolean[n][n][2];
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot(0,0,0,0));

        while (!q.isEmpty()) {
            Robot rb = q.poll();
            int x = rb.x, y = rb.y, h = rb.h, s = rb.s;
            
            if ((x==n-1 && y==n-2 && h==0) || (x==n-2 && y==n-1 && h==1)) return s;
            if (visited[x][y][h]) continue;
            visited[x][y][h] = true;

            int nh = 1-h, ns = s+1;

            if (h == 0) {
                if (y<n-2 && board[x][y+2]==0 && !visited[x][y+1][h]) q.add(new Robot(x, y+1, h, ns));
                if (y>0 && board[x][y-1]==0 && !visited[x][y-1][h]) q.add(new Robot(x, y-1, h, ns));

                if (x<n-1 && y<n-1 && board[x+1][y]==0 && board[x+1][y+1]==0) {
                    if (!visited[x+1][y][h]) q.add(new Robot(x+1, y, h, ns));
                    if (!visited[x][y][nh]) q.add(new Robot(x, y, nh, ns));
                    if (!visited[x][y+1][nh]) q.add(new Robot(x, y+1, nh, ns));
                }

                if (x>0 && y<n-1 && board[x-1][y] == 0 && board[x-1][y+1]==0) {
                    if (!visited[x-1][y][h]) q.add(new Robot(x-1, y, h, ns));
                    if (!visited[x-1][y][nh]) q.add(new Robot(x-1, y, nh, ns));
                    if (!visited[x-1][y+1][nh]) q.add(new Robot(x-1, y+1, nh, ns));
                }
            } else {
                if (x<n-2 && board[x+2][y]==0 && !visited[x+1][y][h]) q.add(new Robot(x+1, y, h, ns));
                if (x>0 && board[x-1][y]==0 && !visited[x-1][y][h]) q.add(new Robot(x-1, y, h, ns));

                if (x<n-1 && y<n-1 && board[x][y+1]==0 && board[x+1][y+1]==0) {
                    if (!visited[x][y+1][h]) q.add(new Robot(x, y+1, h, ns));
                    if (!visited[x][y][nh]) q.add(new Robot(x, y, nh, ns));
                    if (!visited[x+1][y][nh]) q.add(new Robot(x+1, y, nh, ns));
                }

                if (x<n-1 && y>0 && board[x][y-1]==0 && board[x+1][y-1]==0) {
                    if (!visited[x][y-1][h]) q.add(new Robot(x, y-1, h, ns));
                    if (!visited[x][y-1][nh]) q.add(new Robot(x, y-1, nh, ns));
                    if (!visited[x+1][y-1][nh]) q.add(new Robot(x+1, y-1, nh, ns));
                }
            }

        }

        return -1;
    }


    private class Robot {
        int x, y, h, s;
        Robot(int x, int y, int h, int s) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.s = s;
        }
    }
}
