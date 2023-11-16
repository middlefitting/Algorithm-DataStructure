arr = list(map(int, input().split()))
arr.sort()
arr[2] = min(arr[0] + arr[1] - 1, arr[2])
print(sum(arr))
