arr = [int(input()) for _ in range(5)]
answer = 0
if arr[0] < 0:
    answer += arr[0] * arr[2] * -1
if arr[0] < 0 and arr[1] > 0:
    answer += arr[3]
answer += (arr[1] - max(arr[0], 0)) * arr[4]
print(answer)