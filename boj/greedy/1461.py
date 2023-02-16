import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = list(map(int, input().split()))

plus = []
minus = []
cnt = []

# 양수는 양수끼리, 음수는 음수끼리
for a in arr:
    if a > 0:
        plus.append(a)
    else:
        minus.append(abs(a))

# 거리가 먼 순대로
plus.sort(reverse=True)
minus.sort(reverse=True)

for i in range(len(plus)//M):
    cnt.append(plus[i*M])

if len(plus)%M > 0:
    cnt.append(plus[(len(plus)//M)*M])

for i in range(len(minus)//M):
    cnt.append(minus[i*M])

if len(minus)%M > 0:
    cnt.append(minus[(len(minus)//M)*M])

# 마지막은 한 번만 찍기 때문에 따로 빼서 더해줌
cnt.sort()

result = cnt.pop()
result += 2 * sum(cnt)

print(result)
