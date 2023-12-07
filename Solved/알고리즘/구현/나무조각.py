arr = list(map(int, input().split()))
s_arr = arr.copy()
s_arr.sort()

while True:
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            temp = arr[i + 1]
            arr[i + 1] = arr[i]
            arr[i] = temp
            print(" ".join(map(str, arr)))
    if arr == s_arr:
        break
