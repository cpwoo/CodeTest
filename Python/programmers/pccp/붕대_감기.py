def solution(bandage, health, attacks):
    cur = health
    cur -= attacks[0][1]
    if cur <= 0:
        return -1
    
    for i in range(1, len(attacks)):
        time = attacks[i][0]-attacks[i-1][0]-1
        cur += time*bandage[1]
        cur += (time//bandage[0])*bandage[2]
        cur = min(cur, health)
        cur -= attacks[i][1]
        if cur <= 0:
            return -1
    
    return cur
