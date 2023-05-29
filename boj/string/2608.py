import sys
input = lambda: sys.stdin.readline().rstrip()

order = ["I", "V", "X", "L", "C", "D", "M"]
value = [1, 5, 10, 50, 100, 500, 1000]

alpha = {i:j for i,j in zip(order, value)}
num = {i:j for i,j in zip(value, order)}

a, b = input(), input()

val = 0
for v in [a,b]:
    val += alpha[v[-1]]
    for i in range(len(v)-1):
        if alpha[v[i]] < alpha[v[i+1]]:
            val -= alpha[v[i]]
        else:
            val += alpha[v[i]]

print(val)

for v in value[::-1]:
    while val >= v:
        if str(val)[0] == "4":
            val -= 4*v
            print(num[v], end="")
            print(num[v*5], end="")
        elif str(val)[0] == "9":
            v //= 5
            val -= 9*v
            print(num[v], end="")
            print(num[v*10], end="")
        else:
            val -= v
            print(num[v], end="")
