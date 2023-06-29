arr = list(map(int, input().split()))
arr.sort()
if (arr[1] - arr[0]) == 2 * (arr[2] - arr[1]):
    print(arr[0] + arr[2] - arr[1])
elif 2 * (arr[1] - arr[0]) == (arr[2] - arr[1]):
    print(arr[1] + arr[1] - arr[0])
else:
    if (arr[0] - arr[1] + arr[0]) < -100:
        print(arr[2] + arr[1] - arr[0])
    else:
        print(arr[0] - arr[1] + arr[0])
