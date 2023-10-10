def solution(cacheSize, cities):
    answer = 0
    d = {}
    for i, city in enumerate(cities):
        city = city.lower()
        if cacheSize == 0:
            answer += 5
        else:
            if city in d:
                d[city] = i
                answer += 1
            else:
                if len(d.keys()) == cacheSize:
                    target = [k for k, v in d.items() if v == min(d.values())][0]
                    del d[target]
                d[city] = i
                answer += 5
    return answer


cacheSize = 3
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
print(solution(cacheSize, cities)) # 50

cacheSize = 3
cities = ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	
print(solution(cacheSize, cities)) # 21

cacheSize = 2
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]
print(solution(cacheSize, cities)) # 60

cacheSize = 5
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]
print(solution(cacheSize, cities)) # 52

cacheSize = 2
cities = ["Jeju", "Pangyo", "NewYork", "newyork"]
print(solution(cacheSize, cities)) # 16

cacheSize = 0
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
print(solution(cacheSize, cities)) # 25
