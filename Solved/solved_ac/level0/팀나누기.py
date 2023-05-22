import math

arr = list(map(int, input().split()))
answer = math.inf
for i in range(4):
    for j in range(i + 1, 4):
        answer = min(abs(sum(arr) - 2 * (arr[i] + arr[j])), answer)
print(answer)
