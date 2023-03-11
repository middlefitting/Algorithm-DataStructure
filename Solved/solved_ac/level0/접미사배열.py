s = str(input())
arr = []
for i in range(0, len(s)):
    arr.append(s[i:])
arr.sort()
for i in arr:
    print(i)
