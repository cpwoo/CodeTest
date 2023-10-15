package CodeTest.Java.programmers.etc.level2;

public class 혼자서하는틱택토 {
    public int solution(String[] tmp) {
        String[][] board = new String[3][3];
        for (int i=0; i<3; i++) {
            String[] st = tmp[i].split("");
            for (int j=0; j<3; j++) {
                board[i][j] = st[j];
            }
        }

        int o = 0, x = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j].equals("O")) o++;
                else if (board[i][j].equals("X")) x++;
            }
        }
        if (o < x || o > x+1) return 0;

        boolean a = check(board, "O"), b = check(board, "X");
        if (a && b) return 0;
        if ((a && !b) && o == x) return 0;
        if ((!a && b) && o != x) return 0;
        return 1;
    }
    
    private boolean check(String[][] board, String st) {
        for (int i=0; i<3; i++) {
            if (board[i][0].equals(st) && board[i][1].equals(st) && board[i][2].equals(st)) return true;
            else if (board[0][i].equals(st) && board[1][i].equals(st) && board[2][i].equals(st)) return true;
        }
        if (board[0][0].equals(st) && board[1][1].equals(st) && board[2][2].equals(st)) return true;
        if (board[0][2].equals(st) && board[1][1].equals(st) && board[2][0].equals(st)) return true;
        return false;
    }
}
