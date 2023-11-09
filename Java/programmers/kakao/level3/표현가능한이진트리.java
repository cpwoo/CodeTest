package CodeTest.Java.programmers.kakao.level3;

public class 표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            String st = Long.toBinaryString(numbers[i]);
            int j = 0;
            while ((int)Math.pow(2,j)-1 < st.length()) j++;
            while ((int)Math.pow(2,j)-1 != st.length()) st = "0"+st;
            answer[i] = dfs(st) ? 1 : 0;
        }

        return answer;
    }

    private static boolean dfs(String x) {
        int mid = (x.length()-1)/2;
        char root = x.charAt(mid);
        String left = x.substring(0, mid);
        String right = x.substring(mid+1);

        int l = left.length(), r = right.length();
        if (root=='0' && (left.charAt((l-1)/2)=='1' || right.charAt((r-1)/2)=='1')) {
            return false;
        }

        if (l >= 3) return dfs(left) && dfs(right);
        
        return true;
    }
}
