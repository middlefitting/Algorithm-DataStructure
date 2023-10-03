A = float(input())
B = float(input())
arr = []
for i in range(max(int(A ** 0.5) - 1, 1), int((B ** 0.5) + 2)):
    if A <= i ** 2 <= B:
        arr.append(i ** 2)
if len(arr) == 0:
    print(-1)
else:
    print(sum(arr))
    print(min(arr))

