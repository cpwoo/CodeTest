import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    m = int(input())

    arr = []
    for _ in range(m//10+1):
        arr.extend(list(map(int,input().split())))

    print(m//2+1)
    print(arr[0], end=" ")
    if m != 1:
        cnt = 1
        for i in range(2, m, 2):
            print(sorted(arr[:i+1])[(i+1)//2], end=" ")
            cnt += 1
            if cnt == 10:
                print()
                cnt = 0
        else:
            print()
