s = str(input())
l = len(s)
flag = 1
for i in range(l // 2):
    if s[i] != s[l - 1 - i]:
        flag = 0
print(flag)
