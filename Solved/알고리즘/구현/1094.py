N = int(input())
arr = [64]
while sum(arr) != N:
    arr.sort(reverse=True)
    temp = arr.pop()
    temp //= 2
    arr.append(temp)
    if sum(arr) < N:
        arr.append(temp)
print(len(arr))