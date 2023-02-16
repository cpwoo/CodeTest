import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dice = list(map(int, input().split()))

if n == 1:
    print(sum(dice)-max(dice))
else:
    arr = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
    arr.sort()

    n1 = (n-2)*(n-2) + (n-1)*(n-2)*4  # 면이 1개 보이는 블록 개수
    n2 = (n-2)*4 + (n-1)*4            # 면이 2개 보이는 블록 개수
    n3 = 4                            # 면이 3개 보이는 블록 개수

    result = n1 * arr[0] + n2 * sum(arr[:2]) + n3 * sum(arr)
    print(result)
