s = str(input())
flag = True
for i in s:
    if flag:
        print(i, end="")
        flag = False
    if i == '-':
        flag = True
