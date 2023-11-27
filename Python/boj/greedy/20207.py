import sys
input = lambda: sys.stdin.readline().rstrip()

# 반례를 제거하기 위해 366이 아닌 367로 설정
ans = [0]*367

for _ in range(int(input())):
    s, e = map(int, input().split())
    for i in range(s, e+1):
        ans[i] += 1

ret = 0
cnt, _max = 0, 0
for i in range(1, 367):
    if ans[i] != 0:
        cnt += 1
        _max = max(_max, ans[i])
    else:
        ret += cnt*_max
        cnt = 0
        _max = 0

print(ret)
