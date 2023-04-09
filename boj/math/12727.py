import sys
input = lambda: sys.stdin.readline().rstrip()

lst = [5, 27]

for _ in range(2, 30):
    lst.append(6*lst[-1]-4*lst[-2]+1)

for i in range(int(input())):
    n = int(input())
    res = str(lst[n-1]%1000).zfill(3)
    print('Case #{}: {}'.format(i+1, res))
