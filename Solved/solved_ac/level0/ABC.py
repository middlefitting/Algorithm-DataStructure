arr = list(map(int, input().split()))
arr2 = str(input())
arr.sort()
for i in arr2:
    if i == "A":
        print(arr[0], end=" ")
    if i == "B":
        print(arr[1], end=" ")
    if i == "C":
        print(arr[2], end=" ")