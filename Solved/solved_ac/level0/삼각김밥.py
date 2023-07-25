arr = list()
p, g = map(float, input().split())
arr.append(p / g)
for i in range(int(input())):
    p, g = map(float, input().split())
    arr.append(p / g)
print(min(arr) * 1000)
