import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
answer = []
for i in range(1, int(n**0.5)+1):
    if n%i: continue
    p1, p2 = i, n//i
    if not (p1 and p2): continue
    if p1 == p2 or (p1+p2)%2: continue
    answer.append((p1+p2)//2)

if not answer: answer = [-1]
print(*sorted(answer), sep="\n")
