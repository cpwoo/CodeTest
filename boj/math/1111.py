import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))

if N == 1:
    print("A")
elif N == 2:
    if arr[1]-arr[0] == 0:
        print(arr[0])
    else:
        print("A")
else:
    if arr[1]-arr[0] == 0:
        a = 0
    else:
        a = (arr[2]-arr[1])//(arr[1]-arr[0])
    b = arr[1]-arr[0]*a

    for i in range(N-1):
        expect = a*arr[i]+b
        if expect != arr[i+1]:
            print("B")
            exit()

    print(a*arr[-1]+b)
