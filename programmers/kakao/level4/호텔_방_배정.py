def solution(k, room_number):
    answer = []
    rooms = {}
    for num in room_number:
        n = num
        visited = [n]
        while n in rooms:
            n = rooms[n]
            visited.append(n)
        answer.append(n)
        for v in visited:
            rooms[v] = n+1
    return answer


k, room_number = 10, [1,3,4,1,3,1]
print(solution(k, room_number)) # [1,3,4,2,5,6]
