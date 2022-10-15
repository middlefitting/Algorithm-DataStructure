N, M = map(int, input().split())
toFind = list(map(int, input().split()))
arr = [i for i in range(1, N + 1)]
answer = 0
temp = 0
for i in toFind:
    temp_right = temp
    temp_left = temp
    left = 0
    right = 0
    while True:
        if arr[temp_left] == i:
            break
        temp_left -= 1
        left += 1
        if temp_left == -1:
            temp_left = len(arr) - 1
    while True:
        if arr[temp_right] == i:
            break
        temp_right += 1
        right += 1
        if temp_right == len(arr):
            temp_right = 0

    answer += min(left, right)
    arr.pop(arr.index(i))
    temp = temp_right
    if temp == len(arr):
        temp = 0
print(answer)
