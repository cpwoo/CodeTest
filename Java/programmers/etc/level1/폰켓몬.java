package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);
        return Math.min(hs.size(), nums.length/2);
    }
}
