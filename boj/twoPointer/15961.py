import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr.extend(arr)
left, right = 0, 0
dic = defaultdict(int)
res = 0

dic[c] += 1

for right in range(2*n):
    dic[arr[right]] += 1
    
    if right >= k-1:
        res = max(res, len(dic))
        dic[arr[left]] -= 1
        if dic[arr[left]] == 0:
            del dic[arr[left]]
        left += 1
    
print(res)
