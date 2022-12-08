N = int(input())
K = int(input())
right = N * N + 1
left = 1
while left <= right:
    mid = (left + right) // 2
    compare = mid - 1
    midCount = 0
    compareCount = 0
    for i in range(1, N + 1):
        midCount += min(mid // i, N)
        compareCount += min(compare // i, N)
    if midCount >= K > compareCount:
        print(mid)
        break
    if midCount < K:
        left = mid + 1
    if midCount >= K:
        right = mid - 1
