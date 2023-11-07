package CodeTest.Java.programmers.etc.level3;

import java.util.*;

class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return this.x == o.x ? this.y - o.y : this.x - o.x; 
    }
}

public class 퍼즐조각채우기 {
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};

    private static int n;
    private static List<List<Point>> empty = new ArrayList<>();
    private static List<List<Point>> block = new ArrayList<>();
    private static boolean[][] visited;

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    empty.add(bfs(game_board, i, j, 0));
                }
            }
        }

        for (int i=0; i<n; i++) Arrays.fill(visited[i], false);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    block.add(bfs(table, i, j, 1));
                }
            }
        }

        int answer = 0;
        boolean[] check = new boolean[empty.size()];

        for (int i=0; i<block.size(); i++) {
            List<Point> b = block.get(i);
            for (int j=0; j<empty.size(); j++) {
                List<Point> e = empty.get(j);
                if (e.size() == b.size() && !check[j]) {
                    if (rotate(e, b)) {
                        answer += b.size();
                        check[j] = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private List<Point> bfs(int[][] board, int x, int y, int type) {
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        List<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur.x+dx[i], ny = cur.y+dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny] && board[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        result.add(new Point(nx-x, ny-y));
                    }
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    private static boolean rotate(List<Point> empty, List<Point> block) {
        for (int i=0; i<4; i++) {
            int zeroX = block.get(0).x, zeroY = block.get(0).y;
            
            for (int j=0; j<block.size(); j++) {
                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;
            }

            boolean flag = true;

            for (int j=0; j<empty.size(); j++) {
                Point eP = empty.get(j);
                Point bP = block.get(j);
                if (eP.x != bP.x || eP.y != bP.y) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
            else {
                for (int j=0; j<block.size(); j++) {
                    int tmp = block.get(j).x;
                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -tmp;
                }
                Collections.sort(block);
            }
        }

        return false;
    }    
}
