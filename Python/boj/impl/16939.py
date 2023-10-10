import sys
input = lambda: sys.stdin.readline().rstrip()

def pitch_ccw(size=2):
    tmp1, tmp2 = cube[22], cube[22+size]
    cube[22], cube[22+size] = cube[9], cube[9+size]
    cube[9], cube[9+size] = cube[5], cube[5+size]
    cube[5], cube[5+size] = cube[1], cube[1+size]
    cube[1], cube[1+size] = tmp1, tmp2

def roll_ccw(size=2):
    tmp1, tmp2 = cube[17], cube[17+size]
    cube[17], cube[17+size] = cube[10], cube[9]
    cube[10], cube[9] = cube[16], cube[16-size]
    cube[16], cube[16-size] = cube[3], cube[4]
    cube[3], cube[4] = tmp1, tmp2

def yaw_ccw(size=2):
    tmp = cube[21:21+size]
    cube[21:21+size] = cube[17:17+size]
    cube[17:17+size] = cube[5:5+size]
    cube[5:5+size] = cube[13:13+size]
    cube[13:13+size] = tmp

def pitch_cw(size=2):
    for _ in range(3):
        pitch_ccw(size)

def roll_cw(size=2):
    for _ in range(3):
        roll_ccw(size)

def yaw_cw(size=2):
    for _ in range(3):
        yaw_ccw(size)

def check_all_surface():
    for i in range(6):
        for j in range(1, 4):
            if cube[4*i+j] != cube[4*i+(j+1)]:
                return False
    return True


CUBE = [0] + list(map(int, input().split()))
answer = 0

if not answer:
    cube = CUBE[:]
    pitch_ccw(2)
    if check_all_surface():
        answer = 1

if not answer:
    cube = CUBE[:]
    pitch_cw(2)
    if check_all_surface():
        answer = 1

if not answer:
    cube = CUBE[:]
    roll_ccw(2)
    if check_all_surface():
        answer = 1

if not answer:
    cube = CUBE[:]
    roll_cw(2)
    if check_all_surface():
        answer = 1

if not answer:
    cube = CUBE[:]
    yaw_ccw(2)
    if check_all_surface():
        answer = 1

if not answer:
    cube = CUBE[:]
    yaw_cw(2)
    if check_all_surface():
        answer = 1

print(answer)
