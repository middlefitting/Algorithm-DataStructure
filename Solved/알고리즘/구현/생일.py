N = int(input())
arr = list(map(str, input().split()) for _ in range(N))
age = []
for a, b, c, d in arr:
    age.append([a, int(b) + int(c) * 100 + int(d) * 10000])
age.sort(key=lambda x: x[1])
print(age[-1][0])
print(age[0][0])