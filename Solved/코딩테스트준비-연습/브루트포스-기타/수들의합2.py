N, M = map(int, input().split())
arr = list(map(int, input().split()))
sum_arr = [0] * N
sum_arr[0] = arr[0]
for i in range(1, N):
    sum_arr[i] = sum_arr[i - 1] + arr[i]
answer = 0
for i in range(N):
    for j in range(i, N):
        temp = sum_arr[j]
        if i != 0:
            temp -= sum_arr[i - 1]
        if temp == M:
            answer += 1
print(answer)