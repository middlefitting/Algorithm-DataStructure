arr = []
d = dict()
for i in range(10):
    temp = int(input())
    arr.append(temp)
    try:
        d[temp] += 1
    except KeyError:
        d[temp] = 1
a = sum(arr) // 10
b = 0

by = 0
for key, value in d.items():
    if value > by:
        by = value
        b = key
print(a)
print(b)