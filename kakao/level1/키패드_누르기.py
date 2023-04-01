def dist(p, q):
    position = {1:[0, 0], 2:[0, 1], 3:[0, 2],
                4:[1, 0], 5:[1, 1], 6:[1, 2],
                7:[2, 0], 8:[2, 1], 9:[2, 2],
                "*":[3, 0], 0:[3, 1], "#":[3, 2]}
    a, b = position[p], position[q]
    return abs(a[0]-b[0]) + abs(a[1]-b[1])

def solution(numbers, hand):
    answer = ""
    left, right = "*", "#"

    for n in numbers:
        if n in [1, 4, 7]:
            answer += "L"
            left = n
        elif n in [3, 6, 9]:
            answer += "R"
            right = n
        else:
            d_left, d_right = dist(left, n), dist(right, n)
            if d_left < d_right:
                answer += "L"
                left = n
            elif d_left > d_right:
                answer += "R"
                right = n
            else:
                if hand == "left":
                    answer += "L"
                    left = n
                else:
                    answer += "R"
                    right = n    
    return answer


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers, hand)) # "LRLLLRLLRRL"

numbers = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]
hand = "left"
print(solution(numbers, hand)) # "LRLLRRLLLRR"

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
hand = "right"
print(solution(numbers, hand)) # "LLRLLRLLRL"
