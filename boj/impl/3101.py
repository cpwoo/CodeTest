import sys
input = lambda: sys.stdin.readline().rstrip()

def find(y, x):
    if (diagonal % 2 == 0):
        if (diagonal > N):
            return ((diagonal*(diagonal-1))//2) + y - ((diagonal-N)*(diagonal-N))
        return ((diagonal*(diagonal-1))//2) + y
    else:
        if (diagonal > N):
            return ((diagonal*(diagonal+1))//2) - (y-1) - ((diagonal-N)*(diagonal-N))
        return ((diagonal*(diagonal+1))//2) - (y-1)


N, K = map(int, input().split())
commands = list(input())
diagonal = 1

y, x = 0, 0
answer = 1
for command in commands:
    if command == "U":
        diagonal -= 1
        y -= 1
        answer += find(y, x)
    elif command == "D":
        diagonal += 1
        y += 1
        answer += find(y, x)
    elif command == "L":
        diagonal -= 1
        x -= 1
        answer += find(y, x)
    elif command == "R":
        diagonal += 1
        x += 1
        answer += find(y, x)

print(answer)
