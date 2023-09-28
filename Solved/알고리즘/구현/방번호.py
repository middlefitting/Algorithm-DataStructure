number = str(input())
arr = [0] * 10
for n in number:
    arr[int(n)] += 1
if arr[6] < arr[9]:
    t = (arr[9] - arr[6]) // 2
    arr[9] -= t
    arr[6] += t
elif arr[9] < arr[6]:
    t = (arr[6] - arr[9]) // 2
    arr[6] -= t
    arr[9] += t
print(max(arr))