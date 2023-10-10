import sys
input = lambda: sys.stdin.readline().rstrip()

def fill_stars(x, y, n):
    if n == 1:
        stars[y][x] = "*"
        return
    
    x_size = pow(2, n+1)-3
    y_size = pow(2, n)-1
    
    if n%2:
        for i in range(x_size):
            stars[y][x+i] = "*"
        for i in range(y_size):
            stars[y-i][x+i] = "*"
        for i in range(y_size):
            stars[y-i][x+x_size-i-1] = "*"
        
        fill_stars(x+pow(2, n-1), y-(pow(2, n-1)-1), n-1)
    
    else:
        for i in range(x_size):
            stars[y][x+i] = "*"
        for i in range(y_size):
            stars[y+i][x+i] = "*"
        for i in range(y_size):
            stars[y+i][x+x_size-i-1] = "*"
        
        fill_stars(x+pow(2, n-1), y+(pow(2, n-1)-1), n-1)


N = int(input())
X_size = pow(2, N+1)-3
Y_size = pow(2, N)-1
stars = [[' ']*(X_size) for _ in range(Y_size)]

if N%2:
    fill_stars(0, Y_size-1, N)
else:
    fill_stars(0, 0, N)

for s in stars:
    print(''.join(s))
