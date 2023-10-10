import sys
input = lambda: sys.stdin.readline().rstrip()

s = input()
lk, rk = [], []

cnt = 0
for i in s:
    if i == 'K':
        cnt += 1
    else:
        lk.append(cnt)
        
cnt = 0
for i in s[::-1]:
    if i == 'K':
        cnt += 1
    else:
        rk.append(cnt)
rk.reverse()

l, r = 0, len(lk)-1
answer = 0
while l <= r:
    answer = max(answer, r-l+1+2*min(lk[l], rk[r]))
    if lk[l] < rk[r]:
        l += 1
    else:
        r -= 1
print(answer)
