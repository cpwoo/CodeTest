def solution(tickets):
    answer = []
    routes = dict()
    
    for start, end in tickets:
        if start in routes:
            routes[start].append(end)
        else:
            routes[start] = [end]
    
    for k in routes.keys():
        routes[k].sort(reverse=True)
    
    stack = ["ICN"]
    while stack:
        top = stack[-1]
        if (top not in routes) or (not routes[top]):
            answer.append(stack.pop())
        else:
            stack.append(routes[top].pop())
            
    return answer[::-1]


tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
print(solution(tickets)) # ["ICN", "JFK", "HND", "IAD"]

tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
print(solution(tickets)) # ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
