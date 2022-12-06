import math
import sys

answer = math.inf
N, hatk = map(int, sys.stdin.readline().split())
left = 1
right = (1000000 ** 2) * 123456
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

while True:
    tempAtk = hatk
    hmax = (left + right) // 2
    hcur = hmax
    possible = True
    for t, a, h in arr:
        if t == 1:
            hcur -= (math.ceil(h / tempAtk) - 1) * a
            if hcur <= 0:
                possible = False
                break
        if t == 2:
            tempAtk += a
            hcur = min(hmax, hcur + h)
    if possible:
        answer = min(answer, hmax)
    if right - hmax <= 1:
        break
    if possible:
        right = hmax
    else:
        left = hmax

print(answer)
