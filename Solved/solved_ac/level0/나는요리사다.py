arr = [0]
for _ in range(5):
    arr.append(sum(list(map(int, input().split()))))
print(arr.index(max(arr)), max(arr))
