package CodeTest.Java.programmers.etc.level3;

public class 금과은운반하기 {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int len = g.length;
        long answer = (long) 1e15;
        long start = 0, end = answer;

        while (start <= end) {
            long mid = (start+end)/2;
            long gold = 0, silver = 0, total = 0;
            
            for (int i=0; i<len; i++) {
                long cnt = mid/(t[i]*2);
                if (mid%(t[i]*2) >= t[i]) cnt++;
                gold += Math.min(g[i], cnt*w[i]);
                silver += Math.min(s[i], cnt*w[i]);
                total += Math.min(g[i]+s[i], cnt*w[i]);
            }

            if (gold >= a && silver >= b && total >= a+b) {
                end = mid-1;
                answer = Math.min(answer, mid);
            } else {
                start = mid+1;
            }
        }

        return answer;
    }
}
