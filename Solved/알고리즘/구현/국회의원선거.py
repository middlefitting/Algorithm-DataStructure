N = int(input())
A = int(input())
arr = [int(input()) for _ in range(N - 1)]
answer = 0
while A <= max(arr):
    arr.sort(reverse=True)
    answer += 1
    arr[0] -= 1
    A += 1
print(answer)