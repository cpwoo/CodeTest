package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 불량사용자 {
    private static boolean[] check;
    private static Set<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        set = new HashSet<>();

        for (int i=0; i<banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        dfs(0, "", user_id, banned_id);

        return set.size();
    }

    private static void dfs(int depth, String res, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String st = "";
            for (String s: arr) st += s;
            set.add(st);

            return;
        }

        for (int i=0; i<user_id.length; i++) {
            if (check[i] || !user_id[i].matches(banned_id[depth])) continue;
            check[i] = true;
            dfs(depth+1, user_id[i]+" "+res, user_id, banned_id);
            check[i] = false;
        }
    }
}
