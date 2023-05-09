arr1 = []
arr2 = []
for i in range(4):
    arr1.append(int(input()))
for i in range(2):
    arr2.append(int(input()))
print(sum(arr1) - min(arr1) + max(arr2))
