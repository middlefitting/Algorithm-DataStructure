import sys

N, C = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()
answer = 0
left = 0
right = arr[N - 1]
while True:
    mid = (left + right) // 2
    temp = 0
    ctx = 1
    possible = False
    for i in range(N):
        if arr[i] - arr[temp] >= mid:
            temp = i
            ctx += 1
        if ctx == C:
            answer = mid
            possible = True
            break
    if right - mid <= 1:
        break
    if possible:
        left = mid
    else:
        right = mid
print(answer)
