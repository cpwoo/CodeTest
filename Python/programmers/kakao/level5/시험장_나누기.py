import sys
sys.setrecursionlimit(10**6)

def exam_room(node, key, num, links):
    global group
    if node == -1:
        return 0
    left_cnt = exam_room(links[node][0], key, num, links)
    right_cnt = exam_room(links[node][1], key, num, links)
    if left_cnt + right_cnt + num[node] <= key:
        return left_cnt + right_cnt + num[node]
    else:
        if left_cnt + num[node] > key and right_cnt + num[node] <= key:
            group += 1
            return right_cnt + num[node]
        if left_cnt + num[node] <= key and right_cnt + num[node] > key:
            group += 1
            return left_cnt + num[node]
        if left_cnt + num[node] > key and right_cnt + num[node] > key:
            group += 2
            return num[node]
        if left_cnt + num[node] <= key and right_cnt + num[node] <= key:
            group += 1
            return min(left_cnt, right_cnt) + num[node]

group = 1
def solution(k, num, links):
    global group
    parent = [-1]*len(num)
    for node, (a, b) in enumerate(links):
        if a != -1:
            parent[a] = node
        if b != -1:
            parent[b] = node
    root_node = parent.index(-1)
    
    if k > exam_room(root_node, max(num), num, links):
        return max(num)

    lo, hi = max(num), sum(num)
    while lo < hi:
        group = 1
        mid = (lo+hi)//2
        exam_room(root_node, mid, num, links)
        if group > k:
            lo = mid+1
        else:
            hi = mid
    return lo


k = 3
num = [12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1]
links = [[-1, -1], [-1, -1], [-1, -1], [-1, -1], [8, 5], [2, 10], [3, 0], [6, 1], [11, -1], [7, 4], [-1, -1], [-1, -1]]
print(solution(k, num, links)) # 40

k = 1
num = [6, 9, 7, 5]
links = [[-1, -1], [-1, -1], [-1, 0], [2, 1]]
print(solution(k, num, links)) # 27

k = 2
num = [6, 9, 7, 5]
links = [[-1, -1], [-1, -1], [-1, 0], [2, 1]]
print(solution(k, num, links)) # 14

k = 3
num = [6, 9, 7, 5]
links = [[-1, -1], [-1, -1], [-1, 0], [2, 1]]
print(solution(k, num, links)) # 9
