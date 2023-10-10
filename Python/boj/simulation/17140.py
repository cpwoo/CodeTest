import sys
input = lambda: sys.stdin.readline().rstrip()

r, c, k = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(3)]

time = 0

def is_k():
    if r-1 < len(data) and c-1 < len(data[0]):
        if data[r-1][c-1] == k:
            return True
    return False

def update_data():
    tmp_matrix = []
    _max = 0
    for i in range(len(data)):
        nums = set(data[i])
        tmp = []
        for num in nums:
            if num == 0:
                continue
            tmp.append((num, data[i].count(num)))
        _max = max(_max, len(tmp)*2)
        tmp_matrix.append(tmp)
    
    for i in range(len(tmp_matrix)):
        tmp_matrix[i].sort(key=lambda x: (x[1], x[0]))
    
    for i in range(len(tmp_matrix)):
        value = []
        for j in range(len(tmp_matrix[i])):
            value.append(tmp_matrix[i][j][0])
            value.append(tmp_matrix[i][j][1])
        
        value.extend([0]*(_max-len(value)))
        data[i] = value
        
while time < 101:
    if is_k():
        print(time)
        break
    time += 1
    if len(data) >= len(data[0]):
        update_data()
    else:
        data = list(map(list, zip(*data)))
        update_data()
        data = list(map(list, zip(*data)))        
else:
    print(-1)
