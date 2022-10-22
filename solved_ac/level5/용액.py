N = int(input())
answer = [2000000001, 0, N - 1]
arr = list(map(int, input().split()))

left = 0
right = N - 1

while right > left:
    if abs(arr[left] + arr[right]) < abs(answer[0]):
        answer[0] = arr[left] + arr[right]
        answer[1] = left
        answer[2] = right
    if arr[left] + arr[right] == 0:
        break
    elif arr[left] + arr[right] < 0:
        left += 1
    else:
        right -= 1
print(arr[answer[1]], arr[answer[2]])
