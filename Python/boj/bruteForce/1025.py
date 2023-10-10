import sys
input = lambda: sys.stdin.readline().rstrip()

M, N = map(int, input().split())

numbers = [list(map(int, input())) for _ in range(M)]

result = -1

for m in range(M): # 행
    for n in range(N): # 열
        for weight_m in range(-M, M): # 행 공차
            for weight_n in range(-N, N): # 열 공차
                if (weight_m, weight_n) == (0, 0): # 두 공차가 모두 0이면 무한 루프
                    continue
                x, y = m, n
                value = ''
                while (0 <= x < M) and (0 <= y < N):
                    value += str(numbers[x][y])

                    value_int = int(value)
                    value_sqrt = pow(value_int, 0.5)
                    value_decimal = value_sqrt - int(value_sqrt)
                    
                    # 최대 제곱수인지 판단
                    if value_decimal == 0 and value_int > result:
                        result = value_int
                    
                    x += weight_m
                    y += weight_n

print(result)
