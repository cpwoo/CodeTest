def solution(n, m, x, y, r, c, k):
    answer = "impossible"
    stack = [(x, y, "")]
    while stack:
        cx, cy, path = stack.pop()
        if (cx, cy) == (r, c) and len(path) == k:
            answer = path
            break
        remain, shortest = k-len(path), abs(cx-r)+abs(cy-c)
        if remain < shortest or (remain-shortest)&1:
            continue
        if cx-1 >= 1:
            stack.append((cx-1, cy, path+"u"))
        if cy+1 <= m:
            stack.append((cx, cy+1, path+"r"))
        if cy-1 >= 1:
            stack.append((cx, cy-1, path+"l"))
        if cx+1 <= n:
            stack.append((cx+1, cy, path+"d"))
    return answer


n, m, x, y, r, c, k = 3, 4, 2, 3, 3, 1, 5
print(solution(n, m, x, y, r, c, k)) # "dllrl"

n, m, x, y, r, c, k = 2, 2, 1, 1, 2, 2, 2
print(solution(n, m, x, y, r, c, k)) # "dr"

n, m, x, y, r, c, k = 3, 3, 1, 2, 3, 3, 4
print(solution(n, m, x, y, r, c, k)) # "impossible"
