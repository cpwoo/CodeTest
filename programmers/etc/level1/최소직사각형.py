def solution(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)


sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]
print(solution(sizes)) # 4000

sizes = [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]
print(solution(sizes)) # 120

sizes = [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
print(solution(sizes)) # 133
