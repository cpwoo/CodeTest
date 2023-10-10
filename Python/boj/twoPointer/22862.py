import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
s = list(map(int, input().split()))

end = 0
result = 0
tmp = 0
count = 0

for start in range(n):
    while (count <= k and end < n):
        if s[end] % 2 == 1:
            count += 1
        else:
            tmp += 1
        end += 1
        
        if start == 0 and end == n:
            result = tmp
            break
    
    if count == k+1:
        result = max(tmp, result)
    
    if s[start] % 2 == 1:
        count -= 1
    else:
        tmp -= 1

print(result)
