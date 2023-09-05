arr = []
for i in range(5):
    tmp = int(input())
    if tmp in arr:
        arr.pop(arr.index(tmp))
    else:
        arr.append(tmp)
print(arr[0])