import math

N, X = map(int, input().split())
arr = list(map(int, input().split()))
temp =math.inf
for i in range(N - 1):
    if arr[i] + arr[i + 1] < temp:
        temp = arr[i] + arr[i + 1]
print(temp * X)
