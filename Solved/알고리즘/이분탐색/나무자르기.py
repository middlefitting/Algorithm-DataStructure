N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr = arr[0:N].copy()

s = 0
e = max(arr)

while True:
    temp_sum = 0
    mid = (s + e) // 2
    for i in arr:
        if mid < i:
            temp_sum += i - mid
    if temp_sum >= M:
        s = mid
    if temp_sum < M:
        e = mid
    if (e - s <= 1) and (temp_sum >= M):
        print(s)
        break
