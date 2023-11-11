package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

class Tile implements Comparable<Tile> {
    char c;
    int x, y;

    Tile(char c, int x, int y) {
        this.c = c;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tile o) {
        int result = this.c - o.c;
        if (result == 0) {
            result = this.y - o.y;
            if (result == 0) {
                result = this.x - o.x;
            } 
        }
        return result;
    }
}

public class 리틀프렌즈사천성 {
    private static List<Tile> list;
    private static char[][] b;

    public String solution(int m, int n, String[] board) {
        b = new char[m][n];
        for (int i=0; i<board.length; i++) {
            b[i] = board[i].toCharArray();
        }

        list = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                Character c = b[i][j];
                if (Character.isUpperCase(c)) {
                    list.add(new Tile(c, i, j));
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i+=2) {
            Tile t1 = list.get(i);
            Tile t2 = list.get(i+1);
            if (canRemove(t1, t2)) {
                sb.append(t1.c);
                list.remove(t1);
                list.remove(t2);
                b[t1.x][t1.y] = '.';
                b[t2.x][t2.y] = '.';
                i = -2;
            }
        }

        return list.isEmpty() ? sb.toString() : "IMPOSSIBLE";
    }

    private static boolean canRemove(Tile t1, Tile t2) {
        if (t1.x == t2.x) {
            for (int i=t1.y+1; i<t2.y; i++) {
                if (b[t1.x][i] != '.') return false;
            }
            return true;
        }
        else if (t1.y == t2.y) {
            for (int i=t1.x+1; i<t2.x; i++) {
                if (b[i][t1.y] != '.') return false;
            }
            return true;
        }
        else {
            boolean flag1 = true, flag2 = true;
            
            if (t1.x < t2.x) {
                for (int i=t1.y+1; i<t2.y; i++) {
                    if (b[t1.x][i] != '.') {
                        flag1 = false; 
                        break;
                    }
                }

                for(int i=t1.x; i<t2.x; i++){
                    if (!flag1) break;
                    
                    if (b[i][t2.y] != '.') {
                        flag1 = false;
                        break;
                    }
                }

                for(int i=t1.x+1; i<=t2.x; i++){
                    if (b[i][t1.y] != '.') {
                        flag2 = false;
                        break;
                    }
                }

                for(int i=t1.y; i<t2.y; i++){
                    if (!flag2) break;
                    
                    if (b[t2.x][i] != '.') {
                        flag2 = false;
                        break;
                    }
                }
            }
            else {
                for (int i=t1.x-1; i>=t2.x; i--){
                    if (b[i][t1.y] != '.') {
                        flag1 = false;
                        break;
                    }
                }

                for(int i=t1.y; i<t2.y; i++){
                    if (!flag1) break;

                    if (b[t2.x][i] != '.') {
                        flag1 = false;
                        break;
                    }
                }

                for (int i=t1.y+1; i<=t2.y; i++){
                    if (b[t1.x][i] != '.') {
                        flag2 = false;
                        break;
                    }
                }

                for(int i=t1.x; i>t2.x; i--){
                    if (!flag2) break;

                    if (b[i][t2.y] != '.') {
                        flag2 = false;
                        break;
                    }
                }
            }

            return flag1 || flag2;
        }
    }    
}
