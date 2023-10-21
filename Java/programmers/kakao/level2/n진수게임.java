package CodeTest.Java.programmers.kakao.level2;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder st = new StringBuilder();
        for (int i=0; i<t*m; i++) {
            st.append(convert_notation(i, n));
        }
        
        for (int i=p-1; i<t*m; i+=m) {
            answer.append(st.charAt(i));
        }
        
        return answer.toString();
    }
    
    private String convert_notation(int n, int k) {
        String[] s = "0123456789ABCDEF".split("");
        int q = n/k, r = n%k;
        
        return q != 0 ? convert_notation(q, k) + s[r] : s[r];
    }
}
