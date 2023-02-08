import sys
import math

N, K, D = map(int, sys.stdin.readline().split())
arr = []
for i in range(K):
    arr.append(list(map(int, sys.stdin.readline().split())))
left = 1
right = 1000001
answer = math.inf
while left <= right:
    mid = (left + right) // 2
    dotori = 0
    for l, r, i in arr:
        if mid < l:
            continue
        dotori += ((min(mid, r) - l) // i) + 1
    if dotori >= D:
        answer = min(mid, answer)
    if dotori >= D:
        right = mid - 1
    else:
        left = mid + 1
print(answer)
