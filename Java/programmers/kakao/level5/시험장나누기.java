package CodeTest.Java.programmers.kakao.level5;

import java.util.*;

public class 시험장나누기 {
    private static int group = 1;

    public int solution(int k, int[] num, int[][] links) {
        int[] parent = new int[num.length];
        Arrays.fill(parent, -1);
        
        for (int i=0; i<links.length; i++) {
            if (links[i][0] != -1) parent[links[i][0]] = i;
            if (links[i][1] != -1) parent[links[i][1]] = i;
        }

        int root = -1;
        for (int i=0; i<parent.length; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }

        int _max = 0, sum = 0;
        for (int i=0; i<num.length; i++) {
            _max = Math.max(_max, num[i]);
            sum += num[i];
        }

        if (k > exam_room(root, _max, num, links)) return _max;

        int answer = 0;
        int low = _max, high = sum;
        while (low <= high) {
            group = 1;
            int mid = (low+high)/2;
            exam_room(root, mid, num, links);
            if (group <= k) {
                high = mid-1;
                answer = mid;
            }
            else low = mid+1;
        }
        
        return answer;
    }

    private static int exam_room(int node, int key, int[] num, int[][] links) {
        if (node == -1) return 0;
        
        int left_cnt = exam_room(links[node][0], key, num, links);
        int right_cnt = exam_room(links[node][1], key, num, links);

        if (left_cnt+right_cnt+num[node] <= key) {
            return left_cnt+right_cnt+num[node];
        } else {
            if (left_cnt+num[node] > key && right_cnt+num[node] <= key) {
                group += 1;
                return right_cnt+num[node];
            }
            if (left_cnt+num[node] <= key && right_cnt+num[node] > key) {
                group += 1;
                return left_cnt+num[node];
            }
            if (left_cnt+num[node] > key && right_cnt+num[node] > key) {
                group += 2;
                return num[node];
            }
            if (left_cnt+num[node] <= key && right_cnt+num[node] <= key) {
                group += 1;
                return Math.min(left_cnt, right_cnt) + num[node];
            }
        }

        return -1;
    }
}
