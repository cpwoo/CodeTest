import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
W, S = input(), input()

wa = [0]*58
sa = [0]*58

for i in W:
    wa[ord(i)-ord("A")] += 1

answer = 0
start, length = 0, 0
for i in range(m):
    sa[ord(S[i])-ord("A")] += 1
    length += 1

    if length == n:
        if wa == sa:
            answer += 1
        sa[ord(S[start])-ord("A")] -= 1
        start += 1
        length -= 1

print(answer)
