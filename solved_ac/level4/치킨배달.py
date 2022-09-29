import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())

arr = []
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

chicken_area = []
house_area = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            chicken_area.append([i, j])
        if arr[i][j] == 1:
            house_area.append(([i, j]))

combi = list(combinations(chicken_area, M))
answer = 100 * 2500
for com in combi :
    dist_arr = [100] * len(house_area)
    for chicken in com:
        for j in range(len(house_area)):
            temp = abs(chicken[0] - house_area[j][0]) + abs(chicken[1] - house_area[j][1])
            dist_arr[j] = min(temp, dist_arr[j])
    answer = min(answer, sum(dist_arr))

print(answer)