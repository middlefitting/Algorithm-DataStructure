A, B, C = map(int, input().split())
arr = set()
if A <= B:
    arr.add(A)
if B >= A:
    arr.add(B)
arr.add(C)
if abs(C - A) <= B:
    arr.add(abs(C - A))
if abs(B - A) <= B:
    arr.add(abs(B - A))
if abs(C - B) <= B:
    arr.add(abs(C - B))
l = list(arr)
l.sort()
for i in l:
    print(i, end=" ")
