def solution(want, number, discount):
    answer = 0
    
    buy = []
    for w, n in zip(want, number):
        buy.extend([w]*n)
    buy.sort()
    
    n = len(discount)
    for i in range(n):
        if buy == sorted(discount[i:i+10]):
            answer += 1
        
    return answer


want = ["banana", "apple", "rice", "pork", "pot"]
number = [3, 2, 2, 2, 1]
discount = ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
print(solution(want, number, discount)) # 3

want = ["apple"]
number = [10]
discount = ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]
print(solution(want, number, discount)) # 0
