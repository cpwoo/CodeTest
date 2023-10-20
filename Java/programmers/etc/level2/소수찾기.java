package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 소수찾기 {
    static boolean[] chk;
    static String[] nums;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        nums = numbers.split("");
        chk = new boolean[nums.length];
        
        dfs(0, "");

        int answer = 0;
        for (Integer s : set) {
            if (isPrime(s)) answer++;
        }
        return answer;
    }

    private static void dfs(int depth, String cur) {
        if (depth == nums.length) return;
        for (int i=0; i<nums.length; i++) {
            if (!chk[i]) {
                chk[i] = true;
                set.add(Integer.valueOf(cur+nums[i]));
                dfs(depth+1, cur+nums[i]);
                chk[i] = false;
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i=2; i<=(int)Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
}
