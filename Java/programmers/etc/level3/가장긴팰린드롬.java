package CodeTest.Java.programmers.etc.level3;

public class 가장긴팰린드롬 {
    public int solution(String s) {
        int n = s.length();

        for (int i=n; i>0; i--) {
            for (int j=0; j+i<=n; j++) {
                if (chk(s, j, j+i-1)) return i;
            }
        }

        return 0;
    }
    
    private static boolean chk(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
